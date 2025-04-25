package com.shopping.mart.productservice.exception;

import java.util.List;

public class BusinessValidationExceptions extends ApplicationServiceException {
    private static final long serialVersionUID = 1L;

    public BusinessValidationExceptions(List<String> errors) {
        super("Application bussiness validation fails", errors);

    }
}
