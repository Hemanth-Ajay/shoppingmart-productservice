package com.shopping.mart.productservice.dto;

import com.shopping.mart.productservice.entity.Categories;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class ProductDto {
    private UUID productuuid;
    private String productName;
    private String productDescription;
    private BigDecimal productPrice;
    private CategoryDto category;



}
