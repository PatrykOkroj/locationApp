package com.okrojp.comp2.mapper;

import com.okrojp.comp2.model.Device;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DeviceMapper {

    Device toDevice(DeviceTransferObject deviceTransferObject);

    @Mapping(source = "id", target = "deviceId")
    DeviceTransferObject toDeviceTransferObject(Device device);
}
