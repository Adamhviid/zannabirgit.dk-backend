package com.example.demo.controllers;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.models.BookingsEntity;
import com.example.demo.repositories.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
public class BookingsRestController {

    @Autowired
    BookingsRepository bookingsRepository;

    //find all bookings
    @GetMapping("/bookings/all")
    public ResponseEntity<List<BookingsEntity>> findAllBookings() {
        List<BookingsEntity> bookingsEntityList = bookingsRepository.findAll();
        if (bookingsEntityList.size() >= 1) {
            return new ResponseEntity<>(bookingsEntityList, HttpStatus.OK);
        } else {
            throw new ResourceNotFoundException("Der er ingen kunder");
        }
    }

    //find booking by id
    @GetMapping("/bookings/{id}")
    public ResponseEntity<BookingsEntity> findBookingById(@PathVariable Integer id) {
        BookingsEntity bookingsEntity = bookingsRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Booking med id="+id+" findes ikke.")
        );
        return new ResponseEntity<>(bookingsEntity, HttpStatus.OK);
    }

    //post booking
    @ResponseStatus(HttpStatus.CREATED)
    //    @RequestMapping(value="/bookings/create", consumes = "application/json", method = {RequestMethod.POST})
    @PostMapping(value="/bookings/create", consumes = "application/json")
    public BookingsEntity createBooking(@RequestBody BookingsEntity booking) {
        return bookingsRepository.save(booking);
    }

    //delete booking
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/bookings/delete/{id}")
    public void deleteBooking(@PathVariable Integer id) {
        try{
            bookingsRepository.deleteById(id);
        } catch(EmptyResultDataAccessException e){
            System.out.println("Booking med id="+id+" findes ikke." + e.getMessage());
        }
    }
}
