package com.scaler.productservice.services;

import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;

import java.util.List;

public interface CategoryService {
    String[] getAllCategories();
    List<Product> getInCategory(String category);
}
