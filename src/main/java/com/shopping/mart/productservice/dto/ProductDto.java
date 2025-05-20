package com.shopping.mart.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ProductDto {
    private String productuuid;
    private String productName;
    private String productDescription;
    private BigDecimal productPrice;
    private String productImgSrc;
    private CategoryDto category;


    public ProductDto() {

    }
}
