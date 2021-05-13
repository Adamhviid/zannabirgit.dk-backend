package com.example.demo.controllers;

import com.example.demo.repositories.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(value = "*")
@RestController
public class BookingsRestController {

    @Autowired
    BookingsRepository bookingsRepository;
}
