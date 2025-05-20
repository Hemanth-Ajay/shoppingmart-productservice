package com.shopping.mart.productservice.service;

import com.shopping.mart.productservice.dto.CategoryDto;
import com.shopping.mart.productservice.entity.Categories;
import com.shopping.mart.productservice.mapper.CategoryMapper;
import com.shopping.mart.productservice.repository.ICategoriesRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {
    private final CategoryMapper categoryMapper;
    private final ICategoriesRepository iCategoriesRepository;
    @Override
    @Transactional
    public void saveCategory(CategoryDto categoryDto) {
        Categories categoriesEntity = categoryMapper.mapToCategoryEntity(categoryDto);
        iCategoriesRepository.saveAndFlush(categoriesEntity);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Categories> listOfCategories =  iCategoriesRepository.findAll();
        return categoryMapper.getAllCategories(listOfCategories);
    }
}
