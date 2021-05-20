package com.example.demo.controllers;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Customer;
import com.example.demo.services.JPA.CustomerJPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
public class CustomerRestController {

    @Autowired
    CustomerJPAService customerJPAService;

    //find all customers
    @GetMapping("/customers/all")
    public ResponseEntity<List<Customer>> findAllCustomers(){
        List<Customer> customerList = customerJPAService.findAll();
        if (customerList.size() >= 1) {
            return new ResponseEntity<>(customerList, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Der er ingen kunder");
        }
    }

    //find customer by id
    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable Integer id) {
        Customer customer = customerJPAService.findById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    //find customer email by id
    @GetMapping("/customers/email/{email}")
    public Customer findCustomerByEmail(@PathVariable String email) {
        return customerJPAService.getCustomerIdByEmail(email);
    }

    //post customer
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value="/customers/create", consumes = "application/json")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerJPAService.save(customer);
    }

    //delete customer
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/customers/delete/{id}")
    public ResponseEntity<Integer> deleteCustomer(@PathVariable Integer id) {
        try{
            customerJPAService.deleteById(id);
        } catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Kunde med id="+id+" findes ikke.");
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
