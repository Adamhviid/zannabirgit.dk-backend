package com.example.demo.repositories;

import com.example.demo.models.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ServiceRepository extends JpaRepository<Services, Integer> {

}
