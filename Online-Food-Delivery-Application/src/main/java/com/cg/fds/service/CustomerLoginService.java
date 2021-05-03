package com.cg.fds.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fds.controller.CustomerLoginController;
import com.cg.fds.entities.CustomerLogin;
import com.cg.fds.exceptions.removeFailedException;
import com.cg.fds.repositories.ICartRepository;
import com.cg.fds.repositories.ICustomerLoginRepository;


@Service
@Transactional
public class CustomerLoginService implements ICustomerLogin {
	
	@Autowired
	ICustomerLoginRepository repository;
	
	@Autowired
	ICartRepository  repository2;
	Logger logger=LoggerFactory.getLogger(CustomerLoginService.class);
	
	@Override
	public CustomerLogin addCustomerLogin(CustomerLogin login) {
		
		logger.info("Inside service add cutomer login method");
		repository.save(login);
		return login;
	}

	@Override
	public String deleteCustomerLogin(int userid) throws removeFailedException {
		
		logger.info("Inside service delete cutomer login method");
		CustomerLogin login=repository.findById(userid).orElse(null);
		if(login==null)
		{
			throw new removeFailedException("Customer login removal failed !!!");
		}
		repository.deleteById(userid);
		return "Customer deleted successfully...";
	}
	
	@Override
	public String CustomerLogin(String username, String password) {
		
		logger.info("Inside service login cutomer login method");
		CustomerLogin customer = repository.findByUserName(username);
		if(customer == null)
		{
			return "Invalid username...";
		}
		else
		{
			
			String usr = customer.getUserName();
			String pwd = customer.getPassword();
			
			if(username.equals(usr) && password.equals(pwd))
			{
				return "Customer Login successful...";
			}
			else
			{
				return "Invalid password...";
			}
		}
	}
	
	@Override
	public CustomerLogin updateCustomerLogin(CustomerLogin login) {
		
		logger.info("Inside  service update cutomer login method");
		repository.save(login);
		return login;	
	}
	
	@Override
	public String CustomerLogout() {
		
		logger.info("Inside service logout cutomer login method");
		String logout="Logout Successfull !!";
		return logout;
	}
	
}


