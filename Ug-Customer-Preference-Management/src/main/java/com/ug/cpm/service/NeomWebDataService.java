package com.ug.cpm.service;

import java.util.List;

import com.ug.cpm.dto.CustomerData;
import com.ug.cpm.entity.Customer;

public interface NeomWebDataService {
	
	void saveCustomerData(String customerData) throws Exception;
	void saveAllCustomerData(String customersData);
	Customer updateCustomer(Customer customer, int customerId) throws Exception;
	void deleteCustomer(int customerId) throws Exception;
	CustomerData getCustomer(int customerId) throws Exception;
	List<CustomerData> getAllCustomer();
	
}
