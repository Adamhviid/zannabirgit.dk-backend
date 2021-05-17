package com.example.demo.repositories;

import com.example.demo.models.CustomersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<CustomersEntity, Integer> {

    //get customer by id
    @Query("FROM CustomersEntity WHERE customerId =?1")
    CustomersEntity getCustomerById(int customerId);
}
