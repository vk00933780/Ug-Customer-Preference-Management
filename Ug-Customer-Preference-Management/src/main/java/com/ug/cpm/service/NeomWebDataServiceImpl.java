package com.ug.cpm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ug.cpm.entity.Customer;
import com.ug.cpm.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NeomWebDataServiceImpl implements NeomWebDataService {
	
	private CustomerRepository customerRepository;

	@Override
	public void addCustomer(Customer customer) {
		
		customerRepository.save(customer);
	}

	@Override
	public void addAllCustomers(List<Customer> customers) {
		
		customerRepository.saveAll(customers);
	}

	@Override
	public void updateCustomer(Customer customer, int customerId) throws Exception {
		
		Customer customerTemp = customerRepository.findById(customerId).get();
		
		if(customerTemp == null)
			throw new Exception("Customer with ID : "+ customerId + " not found!");
		
		customerRepository.save(customer);

	}

	@Override
	public void deleteCustomer(int customerId) throws Exception {
		
		Customer customer = customerRepository.findById(customerId).get();
		
		if(customer == null)
			throw new Exception("Customer with ID : "+ customerId + " not found!");
		
		customerRepository.save(customer);

	}

}
