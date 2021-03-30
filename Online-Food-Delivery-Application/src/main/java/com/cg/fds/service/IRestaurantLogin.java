package com.cg.fds.service;
import java.util.List;

import com.cg.fds.entities.RestaurantLogin;
import com.cg.fds.exceptions.removeFailedException;

public interface IRestaurantLogin {
	
	public RestaurantLogin addRestaurantLogin(RestaurantLogin login);
	public RestaurantLogin updateRestaurantLogin(RestaurantLogin login);
	public  List <RestaurantLogin> deleteRestaurantLogin(int userid) throws removeFailedException;
	public String candidateLogin(String username,String password);
	public String candidateLogout();
	
}
