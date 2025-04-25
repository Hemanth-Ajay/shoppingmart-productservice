package com.shopping.mart.productservice.exception.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class StandardError {

    private Integer code;
    private String message;
    private String status;
    private String localizedMessage;
    private String clientTransactionId;
    private String transactionId;
    private String description;
    private List<ErrorDetail> details;

}