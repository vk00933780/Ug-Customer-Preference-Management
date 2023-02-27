package com.ug.cpm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ug.cpm.dto.CustomerData;
import com.ug.cpm.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Customer findByCustomerId(int customerId);
	
	@Query("select c as customer, p as customerPersonalityTrait,"
			+ " b as customerBookingHistory, pr as customerPreference "
			+ "from Customer c left join CustomerPersonalityTrait p on c.customerId = p.customerId "
			+ "left join CustomerBookingHistory b on c.customerId = b.customerId "
			+ "left join CustomerPreference pr on c.customerId = pr.customerId")
	List<CustomerData> getAllCustomerData();
	
		
	@Query("select c as customer, p as customerPersonalityTrait,"
			+ " b as customerBookingHistory, pr as customerPreference "
			+ "from Customer c left join CustomerPersonalityTrait p on c.customerId = p.customerId "
			+ "left join CustomerBookingHistory b on c.customerId = b.customerId "
			+ "left join CustomerPreference pr on c.customerId = pr.customerId "
			+ "where c.customerId = ?1")
	CustomerData getCustomerDataById(int customerId);

}
