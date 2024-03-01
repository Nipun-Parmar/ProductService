package com.scaler.productservice.services;


import com.scaler.productservice.dtos.FakeStoreProductDTO;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class FakeStoreCategoryService implements CategoryService{
    private RestTemplate restTemplate;
    @Autowired
    public FakeStoreCategoryService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public String[] getAllCategories() {
        return restTemplate.getForObject("https://fakestoreapi.com/products/categories",String[].class);
    }
    @Override
    public List<Product> getInCategory(String category) {

        FakeStoreProductDTO[] response = restTemplate.getForObject("https://fakestoreapi.com/products/category/" + category,
                FakeStoreProductDTO[].class);
        List<Product> answer = new ArrayList<>();
        for(FakeStoreProductDTO dto:response){
            answer.add(convertFakeStoreProducttoProduct(dto));
        }
        return answer;
    }
    private Product convertFakeStoreProducttoProduct(FakeStoreProductDTO productDTO){
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setTitle(productDTO.getTitle());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setImageURL(productDTO.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(productDTO.getCategory());

        return product;
    }
}
