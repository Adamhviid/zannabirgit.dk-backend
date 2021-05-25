package com.example.demo.repositories;

import com.example.demo.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.sql.Date;
import java.sql.Time;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Query("FROM Booking where bookingDate = ?1 and bookingTime = ?2")
    Booking findByDateTime(Date bookingDate, Time bookingTime);

}
