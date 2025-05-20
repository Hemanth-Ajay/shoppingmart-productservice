package com.shopping.mart.productservice.service;

import com.shopping.mart.productservice.dto.ProductDto;
import com.shopping.mart.productservice.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IProductService {

    void saveProduct(ProductDto productDto);

    List<ProductDto> fetchAllProducts();
}
