package com.scaler.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel{
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = {CascadeType.REMOVE})
    List<Product> products;
    private String name;
}
