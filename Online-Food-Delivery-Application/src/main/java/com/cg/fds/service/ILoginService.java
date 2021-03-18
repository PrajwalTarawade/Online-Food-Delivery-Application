package com.cg.fds.service;

import com.cg.fds.entities.CustomerLogin;

public interface ILoginService {
	
	public CustomerLogin signIn(CustomerLogin login);
	public CustomerLogin signOut(CustomerLogin login);
}
