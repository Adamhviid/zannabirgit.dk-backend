package com.example.demo.repositories;

import com.example.demo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("FROM Customer WHERE customerEmail =?1")
    Customer getCustomerIdByEmail(String customerEmail);
}
