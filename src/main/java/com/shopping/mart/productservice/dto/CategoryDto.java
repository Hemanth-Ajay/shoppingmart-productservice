package com.shopping.mart.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class CategoryDto {
    private String categoryuuid;
    private String categoryName;
    private String categoryDescription;


}
