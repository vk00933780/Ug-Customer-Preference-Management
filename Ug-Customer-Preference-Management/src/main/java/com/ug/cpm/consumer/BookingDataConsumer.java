package com.ug.cpm.consumer;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ug.cpm.dto.CustomerData;
import com.ug.cpm.entity.Customer;
import com.ug.cpm.service.NeomWebDataService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/cpm")
@Slf4j
public class BookingDataConsumer {
	
	@Autowired
	NeomWebDataService neomDataService;
	
	@PostMapping
	public void saveCustomerData(@RequestBody String customerJson) throws Exception {
		
		log.info("in save customer : "+ customerJson);
		neomDataService.saveCustomerData(customerJson);
	}
	
	@PostMapping("/{customerId}")
	public Customer updateCustomerData(@RequestBody Customer customer, @PathVariable int customerId) throws Exception {
		
		log.info("in update customer with ID: "+ customerId);
		return neomDataService.updateCustomer(customer, customerId);
	}
	
	@DeleteMapping("/{customerId}")
	public void removeCustomer(@PathVariable int customerId) throws Exception {
		
		log.info("in remove customer with ID: "+ customerId);
		neomDataService.deleteCustomer(customerId);
	}
	
	@GetMapping("/{customerId}")
	public CustomerData getCustomer(@PathVariable int customerId) throws Exception {
		
		log.info("in getCustomerData with ID: "+ customerId);
		return neomDataService.getCustomer(customerId);
	}
	
	@GetMapping
	public List<CustomerData> getCustomerData() throws Exception {
		
		log.info("in get All Customer Data");
		return neomDataService.getAllCustomer();
	}
	
}
