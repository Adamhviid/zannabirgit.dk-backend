package com.example.demo.controllers;

import com.example.demo.models.BookingsEntity;
import com.example.demo.repositories.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
public class BookingsRestController {

    @Autowired
    BookingsRepository bookingsRepository;

    //find all bookings
    @GetMapping("/bookings/all")
    public List<BookingsEntity> findAllBooking() {
        return bookingsRepository.findAll();
    }

    //find booking by id
    @GetMapping("/bookings/{id}")
    public BookingsEntity printBooking(@PathVariable Integer id) {
        return bookingsRepository.findBookingById(id);
    }

    //delete booking
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/booking/delete/{id}")
    public void deleteBooking(@PathVariable Integer id) {
        try{
            bookingsRepository.deleteById(id);
        } catch(EmptyResultDataAccessException e){
            System.out.println("FEJL I DELETE -" + e.getMessage());
        }
    }
}
