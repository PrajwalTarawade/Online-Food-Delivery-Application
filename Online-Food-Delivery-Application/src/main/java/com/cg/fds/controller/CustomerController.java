package com.cg.fds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fds.entities.Customer;
import com.cg.fds.service.ICustomerService;

@RestController
public class CustomerController {

	@Autowired
	ICustomerService service;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
	{
	    Customer customer2=service.addCustomer(customer);
		return new ResponseEntity<Customer>(customer2,HttpStatus.OK);
	}
}
