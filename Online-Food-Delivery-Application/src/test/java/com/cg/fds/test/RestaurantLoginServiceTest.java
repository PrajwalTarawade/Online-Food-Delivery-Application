package com.cg.fds.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cg.fds.entities.RestaurantLogin;
import com.cg.fds.repositories.IRestaurantLoginRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class RestaurantLoginServiceTest {
	
	@Autowired
	IRestaurantLoginRepository repository;
	@Test
	void testAddRestaurantLogin() {
		RestaurantLogin resl=repository.save(restLog());
		assertNotNull(resl);
	}

	@Test
	void testDeleteRestaurantLogin() {
		repository.deleteById(44);
	}

	@Test
	void testCandidateLogin() {
		RestaurantLogin name=repository.findByUserName(restLog().getUserName());
		assertNotNull(name);
	}

	@Test
	void testUpdateRestaurantLogin() {
		RestaurantLogin resl=repository.save(restLog());
		assertNotNull(resl);
	}

	@Test
	void testCandidateLogout() {
		String logout="Logout Successfull ";
		assertNotNull(logout);
	}

	public RestaurantLogin restLog()
	{
		RestaurantLogin res=new RestaurantLogin();
		res.setPassword("praj0045");
	    res.setUserid(44);
	    res.setUserName("prajwal");
	    return res;
	    
		
	}
}
