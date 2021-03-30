package com.cg.fds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fds.entities.RestaurantLogin;

@Repository
public interface IRestaurantLoginRepository extends JpaRepository<RestaurantLogin, Integer>{
	
	
	public RestaurantLogin findByUserName(String userName);
}
