package com.example.demo.repositories;

import com.example.demo.models.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ServiceRepository extends JpaRepository<Services, Integer> {

    //get product by id
    @Query("FROM Services WHERE serviceId = ?1")
    Services getServicesById(int productId);
}
