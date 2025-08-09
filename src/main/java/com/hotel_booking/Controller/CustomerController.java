package com.hotel_booking.Controller;

import java.net.http.HttpClient;
import java.util.List;

import jakarta.validation.Valid;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.hotel_booking.DTO.CustomerDto;
import com.hotel_booking.DTO.ResponseDto;
import com.hotel_booking.Service.CustomerService;

@RestController
@RequestMapping("/api/Hotel_booking/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	@PostMapping
	public ResponseEntity<ResponseDto<CustomerDto>> saveCustomer(@Valid @RequestBody CustomerDto customerDto)

	{
		CustomerDto saveCustomer = service.saveCustomer(customerDto);
		ResponseDto<CustomerDto> response= new ResponseDto<>();
		response.setData(saveCustomer);
		response.setMessage("customer saved");
		response.setStatusCode("201");
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
//	@GetMapping
//	public ResponseEntity<ResponseDto<List<CustomerDto>>> readAllCustomer()
//	{
//		List<CustomerDto> customers= service.getAllCustomer();
//		ResponseDto<List<CustomerDto>> response= new ResponseDto<>();
//		response.setData(customers);
//		response.setMessage("customers");
//		response.setStatusCode("200");
//
//		return new ResponseEntity<>(response,HttpStatus.OK);
//		}
	
	@DeleteMapping
	public ResponseEntity<ResponseDto<String>>deleteById(@PathVariable Long id)
	
	{
		String s=service.deleteById(id);
		ResponseDto<String> response= new ResponseDto<>();
	    response.setMessage(s);
	    response.setData(s);
	    response.setStatusCode("200");
	    return new ResponseEntity<>(response,HttpStatus.OK);
	}
	@PutMapping
	public ResponseEntity<ResponseDto<CustomerDto>> updateCustomer(@RequestBody CustomerDto customerDto)
	{
		CustomerDto dto=service.updateCustomer(customerDto);
		ResponseDto<CustomerDto> response= new ResponseDto<>();
		response.setMessage("customer updated");
		response.setData(dto);
		response.setStatusCode("200");

		return new ResponseEntity<>(response,HttpStatus.OK);
	}
    @GetMapping
	public ResponseEntity<ResponseDto<CustomerDto>> getCustomerById(@RequestParam long id)
	{
		CustomerDto customerDto=service.getCustomerById(id);
		ResponseDto<CustomerDto> response= new ResponseDto<>();
		response.setData(customerDto);
		response.setMessage("successful got");
		response.setStatusCode("200");
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
