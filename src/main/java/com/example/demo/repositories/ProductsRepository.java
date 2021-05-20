package com.example.demo.repositories;

import com.example.demo.models.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductsRepository extends JpaRepository<ProductsEntity, Integer> {

    @Query("FROM ProductsEntity WHERE productId = ?1")
    ProductsEntity getProductById(int productId);
}
