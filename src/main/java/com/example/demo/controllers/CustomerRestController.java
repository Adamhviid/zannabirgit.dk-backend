package com.example.demo.controllers;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.CustomersEntity;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
public class CustomerRestController {

    @Autowired
    CustomerRepository customerRepository;

    //find all customers
    @GetMapping("/customers/all")
    public ResponseEntity<List<CustomersEntity>> findAllCustomers(){
        List<CustomersEntity> customersEntityList = customerRepository.findAll();
        if (customersEntityList.size() >= 1) {
            return new ResponseEntity<>(customersEntityList, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Der er ingen kunder");
        }
    }

    //find customer by id
    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomersEntity> findCustomerById(@PathVariable Integer id) {
        CustomersEntity customersEntity = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Kunde med id="+id+" finde ikke."));
        return new ResponseEntity<>(customersEntity, HttpStatus.OK);
    }

    //post customer
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value="/customers/create", consumes = "application/json")
    public CustomersEntity createCustomer(@RequestBody CustomersEntity customer) {
        return customerRepository.save(customer);
    }

    //delete customer
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/customers/delete/{id}")
    public void deleteCustomer(@PathVariable Integer id) {
        try{
            customerRepository.deleteById(id);
        } catch(EmptyResultDataAccessException e){
            System.out.println("Kunde med id="+id+" findes ikke." + e.getMessage());
        }
    }
}
