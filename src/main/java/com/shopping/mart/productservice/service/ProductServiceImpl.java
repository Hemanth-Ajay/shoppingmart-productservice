package com.shopping.mart.productservice.service;

import com.shopping.mart.productservice.dto.ProductDto;
import com.shopping.mart.productservice.entity.Product;
import com.shopping.mart.productservice.exception.BusinessValidationExceptions;
import com.shopping.mart.productservice.mapper.ProductMapper;
import com.shopping.mart.productservice.repository.ICategoriesRepository;
import com.shopping.mart.productservice.repository.IProductRepository;
import com.shopping.mart.productservice.validation.ProductBusinessValidation;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements IProductService {

    private final IProductRepository iProductRepository;
    private final ICategoriesRepository iCategoriesRepository;
    private final ProductBusinessValidation productBusinessValidation;
    private final ProductMapper productMapper;

    @Override
    @Transactional
    public void saveProduct(ProductDto productDto) {
        List<String> errors = productBusinessValidation.businessValidationOfProduct(iCategoriesRepository, productDto);
        if (!errors.isEmpty()) {
            throw new BusinessValidationExceptions(errors);
        }
        Product productEntity = productMapper.mapToProductDtoToProductEntity(productDto);
        iProductRepository.saveAndFlush(productEntity);
    }

    @Override
    @Transactional
    public List<ProductDto> fetchAllProducts() {
        List<Product> listProduct = iProductRepository.findAll();
        return productMapper.mapListOfProductEntityToProductDto(listProduct);
    }
}
