package com.example.demo.controllers;

import com.example.demo.models.CustomerEntity;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
public class CustomerRestController {

    @Autowired
    CustomerRepository customerRepository;

    //find all customers
    @GetMapping("/customers/all")
    public List<CustomerEntity> findAllCustomer() {
        return customerRepository.findAll();
    }

    //find customer by id
    @GetMapping("/customers/{id}")
    public CustomerEntity findCustomerById(@PathVariable Integer id) {
        return customerRepository.getCustomerById(id);
    }
}
