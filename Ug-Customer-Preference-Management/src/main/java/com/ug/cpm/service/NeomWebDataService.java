package com.ug.cpm.service;

import java.util.List;

import com.ug.cpm.entity.Customer;

public interface NeomWebDataService {
	
	void addCustomer(Customer customer);
	void addAllCustomers(List<Customer> customers);
	void updateCustomer(Customer customer, int customerId) throws Exception;
	void deleteCustomer(int customerId) throws Exception;
	
}
