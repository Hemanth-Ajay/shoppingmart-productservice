package com.shopping.mart.productservice.repository;


import com.shopping.mart.productservice.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ICategoriesRepository extends JpaRepository<Categories, String> {
}
