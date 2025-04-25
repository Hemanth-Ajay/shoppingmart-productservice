package com.shopping.mart.productservice.exception;

import com.shopping.mart.productservice.exception.dto.ErrorDetail;
import com.shopping.mart.productservice.exception.dto.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(BusinessValidationExceptions.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public StandardError businessValidationExceptionHandler(BusinessValidationExceptions exception) {
        StandardError error = new StandardError();
        error.setCode(HttpStatus.CONFLICT.value());
        error.setMessage("BUSINESS_VALIDATION");
        error.setDetails(processErrorDetails(exception.getErrors()));
        return error;
    }
    private List<ErrorDetail> processErrorDetails(List<String> errors) {
        List<ErrorDetail> details = new ArrayList<>();

        if (errors != null) {
            for (String errorMessage : errors) {
                if (errorMessage.isEmpty() || errorMessage.indexOf(",", 1) < 0)
                    continue;

                String code = errorMessage.substring(0, errorMessage.indexOf(",", 1));
                String message = errorMessage.substring(errorMessage.indexOf(",", 1) + 1);

                ErrorDetail d = new ErrorDetail();
                d.setDetailCode(Integer.valueOf(code.trim()));
                d.setDetail(message.trim());
                details.add(d);
            }
        }

        return details;
    }
}
