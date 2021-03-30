package com.cg.fds.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.fds.entities.RestaurantLogin;
import com.cg.fds.exceptions.removeFailedException;
import com.cg.fds.repositories.IRestaurantLoginRepository;

@Service
@Transactional
public class RestaurantLoginService implements IRestaurantLogin {

	@Autowired
	IRestaurantLoginRepository repository;
	
	Logger logger=LoggerFactory.getLogger(RestaurantLoginService.class);

	@Override
	public RestaurantLogin addRestaurantLogin(RestaurantLogin login) {

		logger.info("Inside service add restaurant login method");
		repository.save(login);
		return login;
	}

	@Override
	public List<RestaurantLogin> deleteRestaurantLogin(int userid) throws removeFailedException {
		
		logger.info("Inside service delete restaurant login method");
		RestaurantLogin login = repository.findById(userid).orElse(null);
		if (login == null) 
		{
			throw new removeFailedException("Restaurant login removal failed !!!");
		}
		repository.deleteById(userid);
		return repository.findAll();
	}

	@Override
	public String candidateLogin(String username, String password) {
		
		logger.info("Inside service login restaurant login method");
		RestaurantLogin rest=repository.findByUserName(username);
		if(rest==null)
		{
			return "Invalid username...";
		}
		else
		{
			
			String usr=rest.getUserName();
			String pwd=rest.getPassword();
			
			if(username.equals(usr) && password.equals(pwd))
			{
				return "Login successful...";
			}
			else
			{
				return "Invalid password...";
			}
		}
	}

	@Override
	public RestaurantLogin updateRestaurantLogin(RestaurantLogin login) {

		logger.info("Inside service update restaurant login method");
		repository.save(login);
		return login;
	}

	@Override
	public String candidateLogout() {
		
		logger.info("Inside service logout restaurant login method");
		String logout = "Logout Successfull ";
		return logout;
	}
}
