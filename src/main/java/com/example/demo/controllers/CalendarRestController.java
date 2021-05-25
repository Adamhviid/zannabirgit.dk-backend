package com.example.demo.controllers;

import com.example.demo.models.BookingCalendarView;
import com.example.demo.services.JPA.BookingCalendarViewJPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
public class CalendarRestController {

    @Autowired
    BookingCalendarViewJPAService bookingCalendarViewJPAService;

    @GetMapping("/calendar/all")
    public List<BookingCalendarView> getCalendarData() {
        return bookingCalendarViewJPAService.findAll();
    }
    @GetMapping("/calendar/sorted")
    public List<BookingCalendarView> getCalendarDataSorted() {
        return bookingCalendarViewJPAService.findAllSorted();
    }

}
