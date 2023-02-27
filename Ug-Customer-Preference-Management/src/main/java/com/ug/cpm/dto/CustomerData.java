package com.ug.cpm.dto;

import com.ug.cpm.entity.Customer;
import com.ug.cpm.entity.CustomerBookingHistory;
import com.ug.cpm.entity.CustomerPersonalityTrait;
import com.ug.cpm.entity.CustomerPreference;

public interface CustomerData {

	Customer getCustomer();
	CustomerPersonalityTrait getCustomerPersonalityTrait();
	CustomerBookingHistory getCustomerBookingHistory();
	CustomerPreference getCustomerPreference();
}
