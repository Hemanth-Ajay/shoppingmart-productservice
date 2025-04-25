package com.shopping.mart.productservice.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "CATEGORIES")
@Table(name = "CATEGORIES_TBL",schema = "SHOPPING")
@AttributeOverrides({@AttributeOverride(name = "objectuuid", column = @Column(name = "CATEGORY_UUID"))})
@Getter
@Setter
public class Categories extends BaseEntity {

    @Column(name = "CATEGORY_NAME")
    private String categoryName;
    @Column(name = "CATEGORY_DESCRIPTION")
    private String categoryDescription;
    @OneToMany(mappedBy = "categories",fetch = FetchType.LAZY)
    private List<Product> product;

    @Override
    public String toString() {
        return "Categories{" +
                ", categoryName='" + categoryName + '\'' +
                ", categoryDescription='" + categoryDescription + '\'' +
                ", product=" + product +
                '}';
    }
}
