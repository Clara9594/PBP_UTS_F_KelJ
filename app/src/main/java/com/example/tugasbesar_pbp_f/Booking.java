package com.example.tugasbesar_pbp_f;

import java.util.Date;

public class Booking {
    public String idBooking;
    public String namaP;
    public String pickupL;
    public String bookingDate;
    public String bookingTime;
    public String carName;
    public String driverAge;
    public String totalPrice;
    public String status;

    public Booking(String idBooking, String namaP, String pickupL, String bookingDate, String bookingTime, String carName, String driverAge, String totalPrice, String status) {
        this.idBooking = idBooking;
        this.namaP = namaP;
        this.pickupL = pickupL;
        this.bookingDate = bookingDate;
        this.bookingTime = bookingTime;
        this.carName = carName;
        this.driverAge = driverAge;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public String getNamaP() {
        return namaP;
    }

    public void setNamaP(String namaP) {
        this.namaP = namaP;
    }

    public String getPickupL() {
        return pickupL;
    }

    public void setPickupL(String pickupL) {
        this.pickupL = pickupL;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getDriverAge() {
        return driverAge;
    }

    public void setDriverAge(String driverAge) {
        this.driverAge = driverAge;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
