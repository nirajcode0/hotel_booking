package com.hotel_booking.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.hotel_booking.Exception.NoUserFoundException;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel_booking.DTO.CustomerDto;
import com.hotel_booking.Entity.Customer;
import com.hotel_booking.Repository.CustomerRepo;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepo customerRepo;

	public CustomerDto saveCustomer(CustomerDto customerDto)
	{
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDto, customer);
		Customer savedCustomer = customerRepo.save(customer);

		CustomerDto returnedDto = new CustomerDto();
		BeanUtils.copyProperties(savedCustomer, returnedDto);
		return returnedDto;
	}

	public List<CustomerDto> getAllCustomer() {
		
		List<Customer> customers =customerRepo.findAll();
		List<CustomerDto> returnedDto= new ArrayList<>();
		for(Customer c:customers)
		{
			CustomerDto dto = new CustomerDto();
			BeanUtils.copyProperties(c, dto);
			returnedDto.add(dto);
		}
		return returnedDto;
		
		
	}

	public String deleteById(Long id) {
		customerRepo.deleteById(id);
		return"deleted";
		
		
	}


	public CustomerDto updateCustomer(CustomerDto customerDto) {
		Customer exixtingCustomer=customerRepo.findById(customerDto.getCustomerId()).get();

		BeanUtils.copyProperties(customerDto, exixtingCustomer, "customerId");
		System.out.println(customerDto.getFullName());
		Customer c= customerRepo.save(exixtingCustomer);

		CustomerDto returnedDto= new CustomerDto();
		BeanUtils.copyProperties(c, returnedDto);


		return returnedDto;
	}

	public CustomerDto getCustomerById(long id) {
		Customer customer = customerRepo.findById(id)
				.orElseThrow(() -> new NoUserFoundException("user not found by id " + id));
		CustomerDto returnedDto=new CustomerDto();

		BeanUtils.copyProperties(customer,returnedDto);
		return returnedDto;
	}
}
