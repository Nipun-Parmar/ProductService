package com.scaler.productservice.controllers;

import com.scaler.productservice.exceptions.ProductNotExistsException;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.repositories.ProductRepository;
import com.scaler.productservice.services.ProductService;
import com.scaler.productservice.services.SelfProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

//@SpringBootTest
class ProductControllerTest {

//    @Autowired
//    private ProductController productController;
//
//    @MockBean
//    private SelfProductService productService;
//
//    @MockBean
//    private ProductRepository productRepository;
//
//    @Test
//    void testProductsSameAsService(){
//        // arrange
//        List<Product> products = new ArrayList<>();
//
//        Product p1 = new Product();
//        p1.setTitle("iPhone 15");
//        products.add(p1);
//
//        Product p2 = new Product();
//        p2.setTitle("iPhone 15 pro");
//        products.add(p2);
//
//        Product p3 = new Product();
//        p3.setTitle("iPhone 15 pro Max");
//        products.add(p3);
//
//        when(
//                productService.getAllProducts()
//        ).thenReturn(
//                products
//        );
//
//        //act
//        ResponseEntity<List<Product>> response = productController.getAllProducts();
//
//        //assert
//        List<Product> productsInResponse = response.getBody();
//        assertEquals(products.size(),productsInResponse.size());
//
//        for(int i = 0; i < productsInResponse.size(); ++i){
//            assertEquals(products.get(i).getTitle(),
//                    productsInResponse.get(i).getTitle());
//        }
//
//    }
//
//    @Test
//    void testNonExistingProductThrowsException(){
//
//        //arrange
//        when(
//                productRepository.findById(10L)
//        ).thenReturn(
//                Optional.empty()
//        );
//
//        //act
//        assertThrows(
//                ProductNotExistsException.class,
//                () -> productController.getSingleProduct(10L));
//
//    }

}