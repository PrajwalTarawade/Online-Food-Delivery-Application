package com.cg.fds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fds.entities.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String>{

	
}
