package com.shopping.mart.productservice.validation;

import com.shopping.mart.productservice.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDtoValidation {
    public List<String> validationOfProduct(ProductDto productDto) {
        ArrayList<String> error = new ArrayList<>();
        if (null == productDto.getProductName()) {
            error.add("4091, either productname is null");

        } else if (null == productDto.getProductDescription()) {
            error.add("4091, either productdescription is null");
        } else if (null == productDto.getProductPrice()) {
            error.add("4091, either productprice is null");
        }
        return error;
    }
}
