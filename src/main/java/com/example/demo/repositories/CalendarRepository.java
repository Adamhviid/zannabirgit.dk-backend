package com.example.demo.repositories;

import com.example.demo.models.BookingCalendarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CalendarRepository extends JpaRepository<BookingCalendarEntity, Integer> {

    @Query("FROM BookingCalendarEntity")
    List<BookingCalendarEntity> getCalendarData();

}
