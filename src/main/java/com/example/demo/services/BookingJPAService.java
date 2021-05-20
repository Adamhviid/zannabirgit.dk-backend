package com.example.demo.services;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.Booking;
import com.example.demo.repositories.BookingRepository;
import org.springframework.stereotype.Service;

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