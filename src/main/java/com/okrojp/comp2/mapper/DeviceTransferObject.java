package com.okrojp.comp2.mapper;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class DeviceTransferObject {

    private Long deviceId;
    @NotNull
    private BigDecimal longitude;
    @NotNull
    private BigDecimal latitude;
}
