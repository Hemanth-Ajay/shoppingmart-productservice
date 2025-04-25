package com.shopping.mart.productservice.service;

import com.shopping.mart.productservice.dto.CategoryDto;

import java.util.List;

public interface ICategoryService {

    public void saveCategory(CategoryDto categoryDto);
    public List<CategoryDto> getAllCategory();
}
