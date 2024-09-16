package com.scaler.productservice.services;

import com.scaler.productservice.exceptions.ProductNotExistsException;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.repositories.CategoryRepository;
import com.scaler.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
@Primary
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    @Autowired
    public SelfProductService(ProductRepository productRepository,
                              CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getSingleProduct(Long id) throws ProductNotExistsException { // in class
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isEmpty()){
            throw new ProductNotExistsException("Product with id: "
                    + id + " does not exist.");
        }
        Product product = productOptional.get();
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long id) {
        return false;
    }

    @Override
    public Product addNewProduct(Product product) { // in class
//        Category category = product.getCategory();
//        if(category.getId() == null) {
//            Category savedcategory = categoryRepository.save(category);
//            product.setCategory(savedcategory);
//        }

        //Initially
//        Optional<Category> categoryOptional =
//                categoryRepository.findByName(product.getCategory().getName());
//        if(categoryOptional.isEmpty()){
//            product.setCategory(categoryRepository.save(product.getCategory()));
//        }else {
//            product.setCategory(categoryOptional.get());
//        }

        // Explaining cascade operation CascadeType.ALL
        Optional<Category> categoryOptional =
                categoryRepository.findByName(product.getCategory().getName());
        if(categoryOptional.isEmpty()){
//            product.setCategory(categoryRepository.save(product.getCategory()));
        }else {
            product.setCategory(categoryOptional.get());
        }
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) { // in class
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isEmpty()) throw new RuntimeException();

        Product savedProduct = productOptional.get();

        if(product.getTitle() != null){
            savedProduct.setTitle(product.getTitle());
        }

        if(product.getDescription() != null){
            savedProduct.setDescription(product.getDescription());
        }

        if(product.getPrice() != null){
            savedProduct.setPrice(product.getPrice());
        }

        if(product.getImageURL() != null){
            savedProduct.setImageURL(product.getImageURL());
        }
        return productRepository.save(savedProduct);
    }
}
