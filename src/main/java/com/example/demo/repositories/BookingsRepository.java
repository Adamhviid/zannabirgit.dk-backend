package com.example.demo.repositories;

import com.example.demo.models.BookingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingsRepository extends JpaRepository<BookingsEntity, Integer> {

    //get booking by id
    @Query("FROM BookingsEntity WHERE bookingId = ?1")
    BookingsEntity findBookingById(int id);

}
