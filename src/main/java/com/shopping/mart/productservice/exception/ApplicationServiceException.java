package com.shopping.mart.productservice.exception;

import lombok.Getter;

import java.util.List;

public class ApplicationServiceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    @Getter
    private final List<String> errors;

    public ApplicationServiceException(String message, List<String> errors) {
        super(message);
        this.errors = errors;
    }
}
