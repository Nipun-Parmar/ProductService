package com.scaler.productservice.controllers;

import com.scaler.productservice.ProductServiceApplication;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts(){
        ResponseEntity<List<Product>> response = new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
        return response;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id")Long id){
        ResponseEntity<Product> response = new ResponseEntity<>(productService.getSingleProduct(id),HttpStatus.OK);
        return response;
    }
    @PostMapping()
    public ResponseEntity<Product> addNewProduct(@RequestBody Product product){
        ResponseEntity<Product> response = new ResponseEntity<>(productService.addNewProduct(product),HttpStatus.OK);
        return response;
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id")Long id, @RequestBody Product product){
        ResponseEntity<Product> response = new ResponseEntity<>(productService.updateProduct(id,product), HttpStatus.OK);
        return response;
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> replaceProduct(@PathVariable("id")Long id, @RequestBody Product product){
        ResponseEntity<Product> response = new ResponseEntity<>(productService.replaceProduct(id,product),HttpStatus.OK);
        return response;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id")Long id){
        productService.deleteProduct(id);
        ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.OK);
        return response;
    }
}
