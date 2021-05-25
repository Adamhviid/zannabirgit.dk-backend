package com.example.demo.services.JPA;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Booking;
import com.example.demo.repositories.BookingRepository;
import com.example.demo.services.BookingService;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Service
public class BookingJPAService implements BookingService {
    BookingRepository bookingRepository;

    public BookingJPAService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking findById(Integer id) {
        return bookingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Booking med id="+id+" findes ikke."));
    }

    public Booking findByDateTime(Date bookingDate, Time bookingTime){
        if(bookingRepository.findByDateTime(bookingDate, bookingTime) == null){
             new ResourceNotFoundException("Booking findes allerede");
        } else {
            System.out.println("ikke null");
        }
        return bookingRepository.findByDateTime(bookingDate, bookingTime);
    }

    @Override
    public Booking save(Booking object) {
        return bookingRepository.save(object);
    }

    @Override
    public void delete(Booking object) {
        bookingRepository.delete(object);
    }

    @Override
    public void deleteById(Integer id) {
        bookingRepository.deleteById(id);
    }
}