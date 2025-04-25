package com.shopping.mart.productservice.validation;

import com.shopping.mart.productservice.dto.ProductDto;
import com.shopping.mart.productservice.entity.Categories;
import com.shopping.mart.productservice.repository.ICategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductBusinessValidation {
    public List<String> businessValidationOfProduct(@Autowired ICategoriesRepository iCategoriesRepository, ProductDto productDto) {
        ArrayList<String> error = new ArrayList<>();
        Optional<Categories> categoryId = iCategoriesRepository.findById(productDto.getCategory().getCategoryuuid());
        if (categoryId.isEmpty()) {
            error.add("5091, the given category is not present create the category first");
        }
        return error;
    }
}
