package com.study.springboot202210dongbin.web.exception;

import lombok.Getter;

import java.util.Map;

public class CustomTestException extends RuntimeException {

    @Getter
    private final Map<String, String> errorMap;

    public CustomTestException(String message, Map<String, String> errorMap) {
        super(message);
        this.errorMap = errorMap;
    }

}
