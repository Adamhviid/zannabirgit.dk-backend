package com.example.demo.controllers;

import com.example.demo.models.ProductsEntity;
import com.example.demo.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
public class productsRestController {

    @Autowired
    ProductsRepository productsRepository;

    @GetMapping("/products/all")
    public List<ProductsEntity> getAllProducts() {
        return productsRepository.findAll();
    }

    @GetMapping("/products/id/{id}")
    public ProductsEntity getProductById(@PathVariable Integer id) {
        return productsRepository.getProductById(id);
    }
}
