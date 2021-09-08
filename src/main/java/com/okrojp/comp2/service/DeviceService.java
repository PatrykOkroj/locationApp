package com.okrojp.comp2.service;

import com.okrojp.comp2.exception.DeviceNotFoundException;
import com.okrojp.comp2.model.Device;
import com.okrojp.comp2.repository.DeviceRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeviceService {
    @Getter
    private final DeviceRepository repository;

    public Device add(Device device) {
        return repository.save(device);
    }

    public Device getById(Long id) {
        return repository.findById(id)
                .orElseThrow(DeviceNotFoundException::new);
    }
}
