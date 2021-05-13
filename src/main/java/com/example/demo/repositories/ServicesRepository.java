package com.example.demo.repositories;

import com.example.demo.models.ServicesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicesRepository extends JpaRepository<ServicesEntity, Integer> {
}
