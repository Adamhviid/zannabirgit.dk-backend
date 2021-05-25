package com.example.demo.repositories;

import com.example.demo.models.BookingCalendarView;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingCalendarViewRepository extends JpaRepository<BookingCalendarView, Integer> {

    @Query("FROM BookingCalendarView")
    List<BookingCalendarView> findAllSorted(Sort sort);

}
