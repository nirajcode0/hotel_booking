package com.hotel_booking.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hotel_booking.Entity.Customer;

import jakarta.transaction.Transactional;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
	
	public Customer findByFullName(String name);
	
	@Query("Select c from Customer c where c.email=:email")
	Optional<Customer> findByEmail(@Param("email")String email);

	@Modifying
    @Transactional
	@Query("Delete  from Customer c where c.email=:email")
	public void deleteByEmail(@Param("email")String email);
    
	@Modifying
	@Transactional
	@Query("UPDATE Customer c SET c.fullName = :name WHERE c.email = :email")
	public void  updateFullNameByEmail(@Param("name") String fullName, @Param("email") String email);
	
}
