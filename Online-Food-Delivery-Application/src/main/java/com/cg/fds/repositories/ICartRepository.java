package com.cg.fds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.fds.entities.FoodCart;

@Repository
public interface ICartRepository  extends JpaRepository<FoodCart, Integer>{

	@Query("select c.cartId from FoodCart c where c.customer.customerId=?1")
	public int findcartByCustomerId(int id);
	
	
}
