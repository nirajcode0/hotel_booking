package com.hotel_booking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel_booking.Entity.Booking;

public interface BookingRepo extends JpaRepository<Booking, Long> {

}
