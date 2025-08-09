package com.hotel_booking.DTO;
import java.util.Date;

public class PaymentDto {
	
	    private Long payment_id;

	    private String status;

	    private Date date;

	    private String method;

	    private double amount;

	    private Long bookingId; // To link with the booking without full entity

	    // Getters and Setters
	    public Long getPaymentId() {
	        return payment_id;
	    }

	    public void setPaymentId(Long payment_id) {
	        this.payment_id = payment_id;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public Date getDate() {
	        return date;
	    }

	    public void setDate(Date date) {
	        this.date = date;
	    }

	    public String getMethod() {
	        return method;
	    }

	    public void setMethod(String method) {
	        this.method = method;
	    }

	    public double getAmount() {
	        return amount;
	    }

	    public void setAmount(double amount) {
	        this.amount = amount;
	    }

	    public Long getBookingId() {
	        return bookingId;
	    }

	    public void setBookingId(Long bookingId) {
	        this.bookingId = bookingId;
	    }
	}


