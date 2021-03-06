package com.example.demo.controllers;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Product;
import com.example.demo.services.JPA.ProductJPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //delete product
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/products/delete/{id}")
    public ResponseEntity<Integer> deleteProduct(@PathVariable Integer id) {
        try {
            productJPAService.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Produkt med id=" + id + " findes ikke.");
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    //post product
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value="/products/create", consumes = "application/json")
    public Product postProduct(@RequestBody Product product) {
        return productJPAService.save(product);
    }

    //edit product
    @PutMapping("/products/edit")
    public Product editProduct(@RequestBody Product product) {
        return productJPAService.save(product);
    }

}
