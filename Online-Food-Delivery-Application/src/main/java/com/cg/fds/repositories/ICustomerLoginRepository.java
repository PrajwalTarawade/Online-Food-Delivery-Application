package com.cg.fds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.fds.entities.Customer;
import com.cg.fds.entities.CustomerLogin;

@Repository
public interface ICustomerLoginRepository extends JpaRepository<CustomerLogin, Integer> {
	
	public CustomerLogin findByUserName(String userName);
	
	//@Query("select c from Customer c where c.email=:email")
	//public Customer getCustomer(@Param("email") String email);

}
