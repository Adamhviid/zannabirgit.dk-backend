package com.example.demo.controllers;

import com.example.demo.models.CustomerEntity;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
public class CustomerRestController {

    @Autowired
    CustomerRepository customerRepository;

    //find all customers
    @GetMapping("/customers/all")
    public List<CustomerEntity> findAllCustomer() {
        System.out.println("hej");
        return customerRepository.findAll();
    }

    //find customer by id
    @GetMapping("/customers/{id}")
    public CustomerEntity findCustomerById(@PathVariable Integer id) {
        return customerRepository.getCustomerById(id);
    }

    //create booking
    @PostMapping(value="localhost:8080/customers/create", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerEntity addCustomer(@RequestBody CustomerEntity customer) {

        return customerRepository.save(customer);
    }
}
