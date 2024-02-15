package com.scaler.productservice.services;

import com.scaler.productservice.ProductServiceApplication;
import com.scaler.productservice.dtos.FakeStoreProductDTO;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.file.FileAlreadyExistsException;

@Service
public class FakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;
    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
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
    @Override
    public Product getSingleProduct(Long id) {
        FakeStoreProductDTO productDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                FakeStoreProductDTO.class);
        return convertFakeStoreProducttoProduct(productDTO);
    }
}
