package com.shopping.mart.productservice.validation;

import com.shopping.mart.productservice.dto.CategoryDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;



@Component
public class CategoryDtoValidation {

    public List<String> validateCategoryDto(CategoryDto categoryDto) {
        ArrayList<String> errors = new ArrayList<>();
        if (null == categoryDto.getCategoryName() || null == categoryDto.getCategoryDescription()) {
            errors.add("4091, both the categoryname or categorydescription is mandatory");
        }
        return errors;
    }
}
