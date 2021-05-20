package com.example.demo.repositories;

import com.example.demo.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    //get booking by id
    @Query("FROM Booking WHERE bookingId = ?1")
    Booking findBookingById(int id);

}
