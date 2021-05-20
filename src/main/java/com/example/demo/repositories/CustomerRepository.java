package com.example.demo.repositories;

import com.example.demo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    //get customer by id
    @Query("FROM Customer WHERE customerId =?1")
    Customer getCustomerById(int customerId);
}
