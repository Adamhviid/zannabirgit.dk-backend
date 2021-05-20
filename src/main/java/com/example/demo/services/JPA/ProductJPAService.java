package com.example.demo.services.JPA;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Booking;
import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductJPAService implements ProductService {
    ProductRepository productRepository;

    public ProductJPAService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product med id="+id+" findes ikke."));
    }

    @Override
    public Product save(Product object) {
        return productRepository.save(object);
    }

    @Override
    public void delete(Product object) {
        productRepository.delete(object);
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
}
