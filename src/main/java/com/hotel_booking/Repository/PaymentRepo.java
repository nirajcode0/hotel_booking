package com.hotel_booking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.hotel_booking.Entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Long> {
	
}


