package com.example.demo.controllers;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Booking;
import com.example.demo.services.BookingJPAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
public class BookingRestController {

    @Autowired
    BookingJPAService bookingJPAService;

    //find all bookings
    @GetMapping("/bookings/all")
    public ResponseEntity<List<Booking>> findAllBookings() {
        List<Booking> bookingList = bookingJPAService.findAll();
        if (bookingList.size() >= 1) {
            return new ResponseEntity<>(bookingList, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Der er ingen kunder");
        }
    }

    //find booking by id
    @GetMapping("/bookings/{id}")
    public ResponseEntity<Booking> findBookingById(@PathVariable Integer id) {
        Booking booking = bookingJPAService.findById(id);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    //post booking
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value="/bookings/create", consumes = "application/json")
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingJPAService.save(booking);
    }

    //delete booking
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/bookings/delete/{id}")
    public ResponseEntity<Integer> deleteBooking(@PathVariable Integer id) {
        try{
            bookingJPAService.deleteById(id);
        } catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Booking med id="+id+" findes ikke.");
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
