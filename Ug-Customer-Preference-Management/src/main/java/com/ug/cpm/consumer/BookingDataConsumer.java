package com.ug.cpm.consumer;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ug.cpm.entity.Customer;
import com.ug.cpm.service.NeomWebDataService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cpm")
@AllArgsConstructor
public class BookingDataConsumer {
	
	NeomWebDataService neomDataService;
	
	@PostMapping
	public void saveCustomerData(@RequestBody Customer customer) {
		
		neomDataService.addCustomer(customer);
	}
	
	@PostMapping("/{customerId}")
	public void updateCustomerData(@RequestBody Customer customer, @PathVariable int customerId) throws Exception {
		
		neomDataService.updateCustomer(customer, customerId);
	}
	
	@DeleteMapping("/{customerId}")
	public void removeCustomer(@PathVariable int customerId) throws Exception {
		
		neomDataService.deleteCustomer(customerId);
	}
	
	/*@PostMapping
	public void loadAllCustomer(@RequestBody List<Customer> customer) {
		
		neomDataService.addCustomer(customer);
	} */
}
