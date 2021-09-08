package com.okrojp.comp2.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Longitude must not be empty")
    @Digits(integer = 3, fraction = 14)
    private BigDecimal longitude;

    @NotNull(message = "Latitude must not be empty")
    @Digits(integer = 3, fraction = 14)
    private BigDecimal latitude;
}
