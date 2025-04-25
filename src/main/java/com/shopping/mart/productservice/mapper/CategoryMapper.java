package com.shopping.mart.productservice.mapper;

import com.shopping.mart.productservice.dto.CategoryDto;
import com.shopping.mart.productservice.entity.Categories;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {
    public Categories mapToCategoryEntity(CategoryDto categoryDto) {
        Categories categoriesEntity = new Categories();
        categoriesEntity.setCategoryDescription(categoryDto.getCategoryDescription());
        categoriesEntity.setCategoryName(categoryDto.getCategoryName());
        return categoriesEntity;
    }

    public List<CategoryDto> getAllCategories(List<Categories> categories) {
        return categories.stream()
                .map(category -> new CategoryDto(category.getObjectuuid(), category.getCategoryName(), category.getCategoryDescription()))
                .collect(Collectors.toList());
    }

}
