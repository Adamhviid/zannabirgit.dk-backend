package com.example.demo.repositories;

import com.example.demo.models.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {

    //get customer by id
    @Query("FROM CustomerEntity WHERE customerId =?1")
    CustomerEntity getCustomerById(int customerId);
}
