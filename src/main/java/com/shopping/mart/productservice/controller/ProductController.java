package com.shopping.mart.productservice.controller;

import com.shopping.mart.productservice.dto.ProductDto;
import com.shopping.mart.productservice.exception.BusinessValidationExceptions;
import com.shopping.mart.productservice.service.IProductService;
import com.shopping.mart.productservice.validation.ProductDtoValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/product/api/v1")
@RequiredArgsConstructor
@CrossOrigin
public class ProductController {
    private final IProductService iProductService;
    private final ProductDtoValidation productDtoValidation;

    @PostMapping(path = "/saveProduct")
    public ResponseEntity<String> saveProduct(@RequestBody ProductDto productDto) {
        List<String> errors = productDtoValidation.validationOfProduct(productDto);
        if(!errors.isEmpty()){
            throw new BusinessValidationExceptions(errors);
        }
        iProductService.saveProduct(productDto);

        return new ResponseEntity<>("Product Created Successfully", HttpStatus.OK);
    }

    @GetMapping(path ="/listOfProducts")
    public ResponseEntity<List<ProductDto>> fetchAllProducts(){

        List<ProductDto> allProducts = iProductService.fetchAllProducts();
        return new ResponseEntity<>(allProducts,HttpStatus.OK);
    }
}
