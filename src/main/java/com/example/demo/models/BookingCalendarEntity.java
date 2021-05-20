package com.example.demo.models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "booking_calendar", schema = "zannabirgit.dk-db", catalog = "")
public class BookingCalendarEntity {
    private int bookingId;
    private Date bookingDate;
    private Time bookingTime;
    private String customerName;
    private String customerEmail;
    private int customerPhone;
    private String serviceName;
    private int serviceLength;

    @Id
    @Column(name = "booking_id")
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
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

    @Basic
    @Column(name = "customer_name")
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Basic
    @Column(name = "customer_email")
    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Basic
    @Column(name = "customer_phone")
    public int getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(int customerPhone) {
        this.customerPhone = customerPhone;
    }

    @Basic
    @Column(name = "service_name")
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Basic
    @Column(name = "service_length")
    public int getServiceLength() {
        return serviceLength;
    }

    public void setServiceLength(int serviceLength) {
        this.serviceLength = serviceLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingCalendarEntity that = (BookingCalendarEntity) o;
        return bookingId == that.bookingId &&
                customerPhone == that.customerPhone &&
                serviceLength == that.serviceLength &&
                Objects.equals(bookingDate, that.bookingDate) &&
                Objects.equals(bookingTime, that.bookingTime) &&
                Objects.equals(customerName, that.customerName) &&
                Objects.equals(customerEmail, that.customerEmail) &&
                Objects.equals(serviceName, that.serviceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, bookingDate, bookingTime, customerName, customerEmail, customerPhone, serviceName, serviceLength);
    }
}
