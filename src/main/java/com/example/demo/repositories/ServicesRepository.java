package com.example.demo.repositories;

import com.example.demo.models.ServicesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ServicesRepository extends JpaRepository<ServicesEntity, Integer> {

    //get product by id
    @Query("FROM ServicesEntity WHERE serviceId = ?1")
    ServicesEntity getServicesById(int productId);
}
