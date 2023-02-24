package com.ug.cpm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ug.cpm.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Customer findByCustomerId(int customerId);

}
