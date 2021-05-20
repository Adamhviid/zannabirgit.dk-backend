package com.example.demo.services.JPA;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.models.BookingCalendarView;
import com.example.demo.repositories.BookingCalendarViewRepository;
import com.example.demo.services.BookingCalendarViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingBookingCalendarViewJPAViewService implements BookingCalendarViewService {
    BookingCalendarViewRepository bookingCalendarViewRepository;

    public BookingBookingCalendarViewJPAViewService(BookingCalendarViewRepository bookingCalendarViewRepository) {
        this.bookingCalendarViewRepository = bookingCalendarViewRepository;
    }

    @Override
    public List<BookingCalendarView> findAll() {
        return bookingCalendarViewRepository.findAll();
    }

    @Override
    public BookingCalendarView findById(Integer id) {
        return bookingCalendarViewRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("BookingCalendarView med id="+id+" findes ikke."));
    }

    @Override
    public BookingCalendarView save(BookingCalendarView object) {
        return bookingCalendarViewRepository.save(object);
    }

    @Override
    public void delete(BookingCalendarView object) {
        bookingCalendarViewRepository.delete(object);
    }

    @Override
    public void deleteById(Integer id) {
        bookingCalendarViewRepository.deleteById(id);
    }
}
