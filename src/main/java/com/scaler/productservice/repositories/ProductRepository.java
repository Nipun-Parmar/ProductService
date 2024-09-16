package com.scaler.productservice.repositories;

import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository
        extends JpaRepository<Product,Long> {

//    List<Product> findByTitleContaining(String word);
//
//    long deleteByTitle(String title);
//
//    List<Product> findByTitleAndDescription(String title,
//                                            String description);
//
//    List<Product> findByPriceLessThanEqual(double price);
//    List<Product> findByPriceBetween(double startRange,
//                                     double endRange);
//
//    List<Product> findByCategory_Id(Long id);

    Optional<Product> findById(Long id);
    // this will return null if there is no product that matches the id

    Product save(Product product);

    @Query("select p from Product p where p.price > 80000 and p.description like '%best%'")
    List<Product> somethingsomething();

    // select *
    // from products p
    // where p.price = ?
    // and p.description = %?%
}
