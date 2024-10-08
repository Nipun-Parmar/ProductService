package com.scaler.productservice.controllers;

import com.scaler.productservice.ProductServiceApplication;
import com.scaler.productservice.commons.AuthenticationCommons;
import com.scaler.productservice.dtos.Role;
import com.scaler.productservice.dtos.UserDto;
import com.scaler.productservice.exceptions.ProductNotExistsException;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private AuthenticationCommons authenticationCommons;
    @Autowired
    public ProductController(ProductService productService,
                             AuthenticationCommons authenticationCommons) {
        this.productService = productService;
        this.authenticationCommons = authenticationCommons;
    }
    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts(){
//        UserDto userDto = authenticationCommons.validateToken(token);
//        if(userDto == null){
//            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//        }
//        boolean isAdmin = false;
//        for(Role role:userDto.getRoles()){
//            if(role.getName().equals("ADMIN")){
//                isAdmin = true;
//                break;
//            }
//        }
//
//        if (!isAdmin){return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);}

        ResponseEntity<List<Product>> response =
                new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
        return response;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id")Long id) throws ProductNotExistsException {
        ResponseEntity<Product> response =
                new ResponseEntity<>(productService.getSingleProduct(id),HttpStatus.OK);
        return response;
    }
    @PostMapping()
    public ResponseEntity<Product> addNewProduct(@RequestBody Product product){
        ResponseEntity<Product> response =
                new ResponseEntity<>(productService.addNewProduct(product),HttpStatus.OK);
        return response;
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id")Long id, @RequestBody Product product){
        ResponseEntity<Product> response =
                new ResponseEntity<>(productService.updateProduct(id,product), HttpStatus.OK);
        return response;
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> replaceProduct(@PathVariable("id")Long id, @RequestBody Product product){
        ResponseEntity<Product> response =
                new ResponseEntity<>(productService.replaceProduct(id,product),HttpStatus.OK);
        return response;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id")Long id){
        productService.deleteProduct(id);
        ResponseEntity<Void> response = new ResponseEntity<>(HttpStatus.OK);
        return response;
    }
}
