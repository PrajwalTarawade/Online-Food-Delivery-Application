package com.cg.fds.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cg.fds.entities.CustomerLogin;
import com.cg.fds.repositories.ICustomerLoginRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class ICustomerLoginTest {

	@Autowired
	ICustomerLoginRepository repository;
	
	@Test
	void testAddCustomerLogin() {
		
		CustomerLogin login=repository.save(getLogin());
		assertNotNull(login);
	}

	@Test
	void testUpdateCustomerLogin() {
		
		CustomerLogin login=repository.save(getLogin());
		assertNotNull(login);
	}

	@Test
	void testDeleteCustomerLogin() {
		
		repository.deleteById(57);
	}

	@Test
	void testCustomerLogin() {
		
		CustomerLogin login=repository.findByUserName("Aniket7");
		assertNotNull(login);
	}

	public CustomerLogin getLogin()
	{
		CustomerLogin login=new CustomerLogin();
		login.setUserid(57);
		login.setUserName("Aniket");
		login.setPassword("A0017");
		return login;
	}

}
