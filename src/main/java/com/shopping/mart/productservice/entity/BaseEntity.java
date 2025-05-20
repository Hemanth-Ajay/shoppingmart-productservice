package com.shopping.mart.productservice.entity;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Data;
import lombok.Getter;

import java.util.UUID;
@MappedSuperclass
@Data
public class BaseEntity {

    @Id
    private String objectuuid;

    @PrePersist
    public void setUuid() {
        this.objectuuid = generateUuid().toString();
    }

    private UUID generateUuid() {
        return UUID.randomUUID();
    }


}
