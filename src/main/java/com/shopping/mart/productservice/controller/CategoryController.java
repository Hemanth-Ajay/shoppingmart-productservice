package com.shopping.mart.productservice.controller;

import com.shopping.mart.productservice.dto.CategoryDto;
import com.shopping.mart.productservice.entity.Categories;
import com.shopping.mart.productservice.exception.BusinessValidationExceptions;
import com.shopping.mart.productservice.repository.ICategoriesRepository;
import com.shopping.mart.productservice.service.CategoryServiceImpl;
import com.shopping.mart.productservice.validation.CategoryDtoValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/category/api/v1")
@CrossOrigin
public class CategoryController {

    private final CategoryDtoValidation categoryDtoValidation;
    private final CategoryServiceImpl categoryService;

    @PostMapping(path = "/saveCategory")
    public ResponseEntity<String> saveCategory(@RequestBody CategoryDto categoryDto) {
        List<String> errors = categoryDtoValidation.validateCategoryDto(categoryDto);
        if (!errors.isEmpty()) {
            throw new BusinessValidationExceptions(errors);
        }
        categoryService.saveCategory(categoryDto);
        return new ResponseEntity<>("saved category", HttpStatus.CREATED);
    }

    @GetMapping(path = "/getAllCategories")
    public ResponseEntity<List<CategoryDto>> fetchAllCategory() {
        List<CategoryDto> allCategory = categoryService.getAllCategory();
        return new ResponseEntity<>(allCategory, HttpStatus.OK);

    }
}
