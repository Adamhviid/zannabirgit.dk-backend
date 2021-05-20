package com.example.demo.controllers;

import com.example.demo.models.BookingCalendarView;
import com.example.demo.services.JPA.BookingBookingCalendarViewJPAViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
public class CalendarRestController {

    @Autowired
    BookingBookingCalendarViewJPAViewService bookingCalendarViewJPAService;

    @GetMapping("/calendar/all")
    public List<BookingCalendarView> getCalendarData() {
        return bookingCalendarViewJPAService.findAll();
    }

}
