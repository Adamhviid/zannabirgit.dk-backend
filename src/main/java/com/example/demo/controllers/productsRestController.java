package com.example.demo.controllers;

import com.example.demo.models.BookingsEntity;
import com.example.demo.models.ProductsEntity;
import com.example.demo.repositories.ProductsRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    //delete product
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/products/delete/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        try{
            productsRepository.deleteById(id);
        } catch(EmptyResultDataAccessException e){
            System.out.println("FEJL I DELETE -" + e.getMessage());
        }
    }

    //edit product
    @PostMapping(value="/products/edit", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductsEntity editProduct(@RequestBody ProductsEntity product) {
        return productsRepository.save(product);
    }

//    @PutMapping("/products/edit/{id}")
//    public ResponseEntity<ProductsEntity> editBooking(@PathVariable(value="id") Integer id, @Valid @RequestBody ProductsEntity product) throws ResourceNotFoundException {
//        ProductsEntity productsEntity = productsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("error"));
//
//        if(product.getProductName() != null){
//            productsEntity.setProductName(product.getProductName());
//        }
//        if(product.getProductPrice() != 0){
//            productsEntity.setProductPrice(product.getProductPrice());
//        }
//
//        final ProductsEntity updatedProductsEntity = productsRepository.save(productsEntity);
//        return ResponseEntity.ok(updatedProductsEntity);
//    }
}
