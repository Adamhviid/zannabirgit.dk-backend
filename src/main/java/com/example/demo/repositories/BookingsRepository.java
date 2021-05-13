package com.example.demo.repositories;

import com.example.demo.models.BookingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingsRepository extends JpaRepository<BookingsEntity, Integer> {
}
