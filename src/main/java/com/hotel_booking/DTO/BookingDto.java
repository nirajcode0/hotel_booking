package com.hotel_booking.DTO;
import java.util.Date;

public class BookingDto {
	    private Long booking_id;

	    private Date date;

	    private String status;

	    private Long customerId; // Reference only, not full Customer object

	    private Long paymentId; // Optional, depending on if payment exists

	    // Getters and Setters
	    public Long getBookingId() {
	        return booking_id;
	    }

	    public void setBookingId(Long booking_id) {
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

	    public Long getCustomerId() {
	        return customerId;
	    }

	    public void setCustomerId(Long customerId) {
	        this.customerId = customerId;
	    }

	    public Long getPaymentId() {
	        return paymentId;
	    }

	    public void setPaymentId(Long paymentId) {
	        this.paymentId = paymentId;
	    }
	}


