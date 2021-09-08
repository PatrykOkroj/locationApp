package com.okrojp.comp2.exception;

import lombok.Data;
import lombok.NonNull;


@Data
public class ExceptionTransferObject {
    @NonNull
    private String description;
}
