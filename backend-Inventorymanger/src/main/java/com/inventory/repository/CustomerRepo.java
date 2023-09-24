package com.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
//	this method goes to JPA Repository and Create query for Parameter customerName and Return the Customer Object
	Customer findByCustomerName(String customerName);
//	this method goes to JPA Repository and Create query for Parameter customerEmail and return the Customer Object
	Customer findByCustomerEmail(String customerEmail);
}
