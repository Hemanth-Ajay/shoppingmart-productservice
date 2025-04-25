package com.shopping.mart.productservice.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name = "PRODUCT")
@Table(name = "PRODUCT_TBL", schema = "SHOPPING")
@Getter
@Setter
@AttributeOverride(name = "objectuuid", column = @Column(name = "PRODUCT_UUID"))
public class Product extends BaseEntity {

    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "PRODUCT_DESCRIPTION")
    private String productDescription;
    @Column(name = "PRODUCT_PRICE")
    private BigDecimal productPrice;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_UUID")
    private Categories categories;

    @Override
    public String toString() {
        return "Product{" +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                ", categories=" + categories +
                '}';
    }


}
