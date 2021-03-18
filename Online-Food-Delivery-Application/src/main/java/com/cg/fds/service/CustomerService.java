package com.cg.fds.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fds.entities.Customer;
import com.cg.fds.repositories.ICustomerRepository;

@Service
@Transactional
public class CustomerService implements ICustomerService{

	@Autowired
	ICustomerRepository repository;
	
	@Override
	public Customer addCustomer(Customer customer) {

		repository.save(customer);
		return customer;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer removeCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer viewCustomer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> viewAllCustomer(String restaurantname) {
		// TODO Auto-generated method stub
		return null;
	}

}
