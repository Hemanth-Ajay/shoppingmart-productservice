package com.shopping.mart.productservice.mapper;

import com.shopping.mart.productservice.dto.CategoryDto;
import com.shopping.mart.productservice.dto.ProductDto;
import com.shopping.mart.productservice.entity.Categories;
import com.shopping.mart.productservice.entity.Product;
import com.shopping.mart.productservice.repository.ICategoriesRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final ICategoriesRepository iCategoriesRepository;
    public Product mapToProductDtoToProductEntity(ProductDto productDto) {
        Product productEntity = new Product();
        Categories categoriesEntity = iCategoriesRepository.findById(productDto.getCategory().getCategoryuuid())
                        .orElseGet(()->{
                            // Step 2: Create new category if not present
                            Categories newCategory = new Categories();
                            newCategory.setObjectuuid(productDto.getCategory().getCategoryuuid());
                            newCategory.setCategoryName(productDto.getCategory().getCategoryName());
                            newCategory.setCategoryDescription(productDto.getCategory().getCategoryDescription());
                            return iCategoriesRepository.saveAndFlush(newCategory);
                        });
//        categoriesEntity.setObjectuuid(productDto.getCategory().getCategoryuuid());
//        categoriesEntity.setCategoryName(productDto.getCategory().getCategoryName());
//        categoriesEntity.setCategoryDescription(productDto.getCategory().getCategoryDescription());
        productEntity.setProductName(productDto.getProductName());
        productEntity.setProductDescription(productDto.getProductDescription());
        productEntity.setProductPrice(productDto.getProductPrice());
        productEntity.setCategories(categoriesEntity);
        productEntity.setProductImageSrc(productDto.getProductImgSrc());
        return productEntity;
    }

    public List<ProductDto> mapListOfProductEntityToProductDto(List<Product> listProduct) {
       return listProduct.stream().map(product -> {
            ProductDto productDto = new ProductDto();
            productDto.setProductName(product.getProductName());
            productDto.setProductDescription(product.getProductDescription());
            productDto.setProductPrice(product.getProductPrice());
            productDto.setProductuuid(product.getObjectuuid());
            productDto.setProductImgSrc(product.getProductImageSrc());
            productDto.setCategory(CategoryDto.builder().categoryDescription(product.getCategories().getCategoryDescription())
                    .categoryName(product.getCategories().getCategoryName()).categoryuuid(product.getCategories().getObjectuuid())
                    .build());
            return productDto;
        }).collect(Collectors.toList());
    }
}
