package com.hotel_booking;


import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.hotel_booking.Entity.Booking;
import com.hotel_booking.Entity.Customer;
import com.hotel_booking.Entity.Payment;
import com.hotel_booking.Repository.BookingRepo;
import com.hotel_booking.Repository.CustomerRepo;

import jakarta.transaction.Transactional;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	BookingRepo bookingRepo;
//	@Test
//	 public void addData()
//	 {
//		Customer c= new Customer();
//		c.setEmail("niraj@gmail.com.com");
//		c.setFullName("niraj kumar");
//		c.setMobile("6202973502");
//		c.setSex("male");
//		customerRepo.save(c);
//		
//	}
	
	
//	@Test
//	@Transactional
//	@Rollback(value=false)
//	public void addBookings()
//	{
//		Customer customer = customerRepo.findById(1L).get(); // existing
//
//		Booking booking = new Booking();
//		booking.setCustomer(customer);
//		booking.setStatus("BOOKED");
//		booking.setDate(new Date());
//
//		Payment payment = new Payment();
//		payment.setAmount(2000);
//		payment.setMethod("CARD");
//		payment.setStatus("payment successfulll");
//		payment.setDate(new Date());
//		payment.setBooking(booking);
//
//		booking.setPayment(payment); // link both ways
//
//		bookingRepo.save(booking); // Only booking is saved, payment is auto-saved
//
//		
//		
//	}
//	
	
//	@Test
//	public void deleteBooking()
//	{
//		bookingRepo.deleteById(2L);
//		System.out.println("deleted");
//	}
	
	@Test
	@Transactional
	public void getBookingsViaCustomer()
	{
		Customer customer= customerRepo.findById(1L).get();
		List<Booking> bookings=customer.getBookings();
		for(Booking book: bookings)
		{
			System.out.println(book.getStatus());
		}
	}
	
	

}
