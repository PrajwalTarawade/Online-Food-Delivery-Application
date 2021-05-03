package com.cg.fds.service;
import java.util.List;

import com.cg.fds.entities.CustomerLogin;
import com.cg.fds.exceptions.removeFailedException;


public interface ICustomerLogin {
	public CustomerLogin addCustomerLogin(CustomerLogin login);
	public CustomerLogin updateCustomerLogin(CustomerLogin login);
	public String deleteCustomerLogin(int userid) throws removeFailedException;
	public String CustomerLogin(String username,String password);
	public String CustomerLogout();
}
