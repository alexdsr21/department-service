package com.sample.micro.departmentservice.exception;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class EmptyInputException extends RuntimeException {

    private final String errorCode;
    private final String errorMessage;
}
