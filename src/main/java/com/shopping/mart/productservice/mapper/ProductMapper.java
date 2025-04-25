package com.shopping.mart.productservice.mapper;

import com.shopping.mart.productservice.dto.ProductDto;
import com.shopping.mart.productservice.entity.Categories;
import com.shopping.mart.productservice.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product mapToProductDtoToProductEntity(ProductDto productDto) {
        Product productEntity = new Product();
        Categories categoriesEntity = new Categories();
        categoriesEntity.setObjectuuid(productDto.getCategory().getCategoryuuid());
        categoriesEntity.setCategoryName(productDto.getCategory().getCategoryName());
        categoriesEntity.setCategoryDescription(productDto.getCategory().getCategoryDescription());
        productEntity.setProductName(productDto.getProductName());
        productEntity.setProductDescription(productDto.getProductDescription());
        productEntity.setProductPrice(productDto.getProductPrice());
        productEntity.setCategories(categoriesEntity);
        return productEntity;
    }
}
