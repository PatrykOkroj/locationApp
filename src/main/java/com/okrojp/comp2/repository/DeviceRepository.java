package com.okrojp.comp2.repository;

import com.okrojp.comp2.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
