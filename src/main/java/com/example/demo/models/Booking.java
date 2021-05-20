package com.example.demo.models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "bookings", schema = "zannabirgit.dk-db", catalog = "")
public class Booking {
    private int bookingId;
    private int serviceId;
    private int customerId;
    private Date bookingDate;
    private Time bookingTime;

    @Id
    @Column(name = "booking_id")
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    @Basic
    @Column(name = "service_id")
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    @Basic
    @Column(name = "customer_id")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "booking_date")
    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    @Basic
    @Column(name = "booking_time")
    public Time getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Time bookingTime) {
        this.bookingTime = bookingTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking that = (Booking) o;
        return bookingId == that.bookingId &&
                serviceId == that.serviceId &&
                customerId == that.customerId &&
                Objects.equals(bookingDate, that.bookingDate) &&
                Objects.equals(bookingTime, that.bookingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, serviceId, customerId, bookingDate, bookingTime);
    }
}
