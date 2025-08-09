package com.hotel_booking.DTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;

import java.util.List;

public class CustomerDto {
	    private Long customer_id;
	@NotBlank(message = "Full name is required")
	@Size(min = 2, max = 50, message = "Full name must be between 2 and 50 characters")
	    private String fullName;

	   @NotBlank(message = "Email is required")
	   @Email(message = "Invalid email format")
	    private String email;

	@NotBlank(message = "Mobile number is required")
	@Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
	    private String mobile;

	@NotBlank(message = "Sex is required")
	@Pattern(regexp = "^(Male|Female|Other)$", message = "Sex must be Male, Female or Other")
	    private String sex;

	    // Optional: Include booking IDs (not full Booking entity to keep it lightweight)
	    private List<Long> bookingIds;

	    // Getters & Setters
	    public Long getCustomerId() {
	        return customer_id;
	    }

	    public void setCustomerId(Long customerId) {
	        this.customer_id = customerId;
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

	    public List<Long> getBookingIds() {
	        return bookingIds;
	    }

	    public void setBookingIds(List<Long> bookingIds) {
	        this.bookingIds = bookingIds;
	    }
	}

