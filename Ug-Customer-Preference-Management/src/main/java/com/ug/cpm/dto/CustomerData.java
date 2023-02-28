package com.ug.cpm.dto;

import java.util.List;

import com.ug.cpm.entity.Customer;
import com.ug.cpm.entity.CustomerBookingHistory;
import com.ug.cpm.entity.CustomerPersonalityTrait;
import com.ug.cpm.entity.CustomerPreference;

public interface CustomerData {

	Customer getCustomer();
	CustomerPersonalityTrait getCustomerPersonalityTrait();
	List<CustomerBookingHistory> getCustomerBookingHistory();
	List<CustomerPreference> getCustomerPreference();
}
