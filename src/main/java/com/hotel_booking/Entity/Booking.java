package com.hotel_booking.Entity;

import java.util.Date;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long booking_id;
	
	private Date date;
	
	private String status;
	
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "customer_id")
	private  Customer customer;
	 
	 @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
	 private Payment payment;

	 
	public Payment getPayment() {
		return payment;
	}

	 public void setPayment(Payment payment) {
		 this.payment = payment;
	 }

	public Customer getCustomer() {
		return customer;
	}

	 public void setCustomer(Customer customer) {
		 this.customer = customer;
	 }

	public long getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(long booking_id) {
		this.booking_id = booking_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}

