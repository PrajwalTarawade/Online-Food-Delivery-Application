package com.cg.fds.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fds.entities.RestaurantLogin;
import com.cg.fds.exceptions.removeFailedException;
import com.cg.fds.service.IRestaurantLogin;


@RestController
public class RestaurantLoginController {
		
		@Autowired
		IRestaurantLogin service;
		
		Logger logger=LoggerFactory.getLogger(RestaurantLoginController.class);
		
		@PostMapping("/addRestaurantLogin")
		public ResponseEntity<RestaurantLogin> addRestaurantLogin(@Valid @RequestBody RestaurantLogin login) {
					
			logger.info("Inside add restaurant login method");
			RestaurantLogin loginData = service.addRestaurantLogin(login);
			return new ResponseEntity<RestaurantLogin>(loginData, HttpStatus.OK);
		}
		
		@PutMapping("/updateRestaurantLogin")
		public ResponseEntity<RestaurantLogin> updateRestaurantLogin(@Valid @RequestBody RestaurantLogin login) {
			
			logger.info("Inside update restaurant login method");
			RestaurantLogin loginData = service.updateRestaurantLogin(login);
			return new ResponseEntity<RestaurantLogin>(loginData, HttpStatus.OK);
		}
		
		@DeleteMapping("/deleteRestaurantLogin/{userId}")
		public ResponseEntity<List<RestaurantLogin>> deleteRestaurantLogin(@PathVariable int userId) throws removeFailedException {
			
			logger.info("Inside delete restaurant login method");
			List<RestaurantLogin> restList = service.deleteRestaurantLogin(userId);
			return new ResponseEntity<List<RestaurantLogin>>(restList, HttpStatus.OK);
		}
		@GetMapping("/restaurantLogin/{username}/{password}")
		public ResponseEntity<String> candidateLogin(@PathVariable String username,@PathVariable String password) 
		{
			
			logger.info("Inside login restaurant login method");
			String login=service.candidateLogin(username,password);
			return new ResponseEntity<String>(login, HttpStatus.OK);
		}
		
		@GetMapping("/restaurantLogout")
		public ResponseEntity<String> candidateLogout() 
		{
			logger.info("Inside logout restaurant login method");
			String logout=service.candidateLogout();
			return new ResponseEntity<String>(logout, HttpStatus.OK);
		}
}