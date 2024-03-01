package com.scaler.productservice.controllers;

import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class CategoryController {
    private CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @GetMapping("/categories")
    public ResponseEntity<String[]> getAllCategories(){
        ResponseEntity<String[]> response = new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
        return response;
    }
    @GetMapping("/category/{category}")
    public ResponseEntity<List<Product>> getInCategory(@PathVariable("category")String category){
        ResponseEntity<List<Product>> response = new ResponseEntity<>(categoryService.getInCategory(category),HttpStatus.OK);
        return  response;
    }
}
