package com.example.demo.controllers;

import com.example.demo.models.Product;
import com.example.demo.services.JPA.ProductJPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
public class ProductRestController {

    @Autowired
    ProductJPAService productJPAService;

    @GetMapping("/products/all")
    public List<Product> getAllProducts() {
        return productJPAService.findAll();
    }

    @GetMapping("/products/id/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productJPAService.findById(id);
    }
}
