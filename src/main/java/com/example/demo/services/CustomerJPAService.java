package com.example.demo.services;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerJPAService implements CustomerService {
    CustomerRepository customerRepository;

    public CustomerJPAService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Kunde med id="+id+" finde ikke."));
    }

    @Override
    public Customer save(Customer object) {
        return customerRepository.save(object);
    }

    @Override
    public void delete(Customer object) {
        customerRepository.delete(object);
    }

    @Override
    public void deleteById(Integer id) {
        customerRepository.deleteById(id);
    }
}
