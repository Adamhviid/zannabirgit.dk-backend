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

    //delete product
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/products/delete/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        try{
            productsRepository.deleteById(id);
        } catch(EmptyResultDataAccessException e){
            System.out.println("FEJL I DELETE -" + e.getMessage());
        }
    }

    //edit product
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value="/products/edit", consumes = "application/json")
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
