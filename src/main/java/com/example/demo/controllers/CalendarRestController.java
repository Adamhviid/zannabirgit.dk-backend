package com.example.demo.controllers;


import com.example.demo.models.BookingCalendarEntity;
import com.example.demo.repositories.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
public class CalendarRestController {

    @Autowired
    CalendarRepository calendarRepository;

    @GetMapping("/calendar/all")
    public List<BookingCalendarEntity> getCalendarData() {
        return calendarRepository.getCalendarData();
    }

}
