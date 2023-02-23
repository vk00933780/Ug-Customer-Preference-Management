package com.ug.cpm.consumer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ug.cpm.entity.Customer;
import com.ug.cpm.service.NeomWebDataService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/cpm")
//@AllArgsConstructor
@Slf4j
public class BookingDataConsumer {
	
	@Autowired
	NeomWebDataService neomDataService;
	
	@PostMapping
	public void saveCustomerData(@RequestBody Customer customer) {
		
		log.info("in save customer : "+ customer.toString());
		neomDataService.addCustomer(customer);
	}
	
	@PostMapping("/{customerId}")
	public void updateCustomerData(@RequestBody Customer customer, @PathVariable int customerId) throws Exception {
		
		log.info("in update customer with ID: "+ customerId);
		neomDataService.updateCustomer(customer, customerId);
	}
	
	@DeleteMapping("/{customerId}")
	public void removeCustomer(@PathVariable int customerId) throws Exception {
		
		log.info("in remove customer with ID: "+ customerId);
		neomDataService.deleteCustomer(customerId);
	}
	
	/*@PostMapping
	public void loadAllCustomer(@RequestBody List<Customer> customer) {
		
		neomDataService.addCustomer(customer);
	} */
}
