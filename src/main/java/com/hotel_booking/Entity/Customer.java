package com.hotel_booking.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customer_id;
	
	private String fullName;
	
	private String email;
	
	private String mobile;
	
	private String sex;
	
	 @OneToMany(mappedBy = "customer", cascade =CascadeType.ALL, orphanRemoval = true)
	private List<Booking> bookings=new ArrayList<>();

	 
	public List<Booking> getBookings() {
		return bookings;
	}

	 public void setBookings(List<Booking> bookings) {
		 this.bookings = bookings;
	 }

	 public void setCustomer_id(long customer_id) {
		 this.customer_id = customer_id;
	 }

	public long getCustomer_id() {
		return customer_id;
	}

	public void setCustommer_id(long custommer_id) {
		this.customer_id = custommer_id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	

}
