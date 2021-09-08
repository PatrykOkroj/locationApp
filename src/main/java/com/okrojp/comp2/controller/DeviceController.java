package com.okrojp.comp2.controller;

import com.okrojp.comp2.exception.ExceptionTransferObject;
import com.okrojp.comp2.mapper.DeviceMapper;
import com.okrojp.comp2.mapper.DeviceTransferObject;
import com.okrojp.comp2.model.Device;
import com.okrojp.comp2.exception.DeviceNotFoundException;
import com.okrojp.comp2.service.DeviceService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/device")
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceService service;

    private final DeviceMapper mapper;

    @GetMapping("/{id}")
    ResponseEntity<DeviceTransferObject> getDevice(@PathVariable Long id) {
        Device device = service.getById(id);
        DeviceTransferObject deviceTransferObject = mapper.toDeviceTransferObject(device);
        return ResponseEntity.ok(deviceTransferObject);
    }

    @PostMapping
    public ResponseEntity<DeviceTransferObject> addDevice(@Valid @RequestBody DeviceTransferObject deviceTransferObject, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        Device device = mapper.toDevice(deviceTransferObject);
        var dev = service.add(device);
        deviceTransferObject.setDeviceId(dev.getId());
        return ResponseEntity.ok(deviceTransferObject);
    }

    @ExceptionHandler(DeviceNotFoundException.class)
    public ResponseEntity<ExceptionTransferObject> onDeviceNotFound(DeviceNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ExceptionTransferObject("Device not found!"));
    }
}
