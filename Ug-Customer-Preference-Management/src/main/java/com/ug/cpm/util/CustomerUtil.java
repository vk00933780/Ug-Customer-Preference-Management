package com.ug.cpm.util;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ug.cpm.entity.Customer;
import com.ug.cpm.entity.CustomerBookingHistory;
import com.ug.cpm.entity.CustomerPersonalityTrait;
import com.ug.cpm.entity.CustomerPreference;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomerUtil {

	private static ObjectMapper mapper = new ObjectMapper();

	public static final Customer parseCustomer(String inputJsn) throws Exception {

		log.info("In Customer Util:parseCustomer");
		JSONObject json = JsonUtils.getJson(inputJsn);

		Customer customer = mapper.readValue(json.toString(), Customer.class);
		log.info("customer : "+ customer.toString());
		return customer;
	}

	public static final List<CustomerPreference> parseCustomerPreference(String inputJsn, Customer customer) throws Exception {

		log.info("In CustomerPreference Util:parseCustomerPreference");
		
		List<CustomerPreference> preferences = new ArrayList<>();
		
		JSONObject json = JsonUtils.getJson(inputJsn);
		
		JSONArray jsonArr = json.getJSONArray("preferences");
 
		for(int i=0; i<jsonArr.length(); i++) {
			JSONObject prefrenceJson = (JSONObject) jsonArr.get(i);
			CustomerPreference preference = mapper.readValue(prefrenceJson.toString(), CustomerPreference.class);
			preference.setCustomerId(customer.getCustomerId());
			preference.setCustomerFirstName(customer.getCustomerFirstName());
			preference.setCustomerLastName(customer.getCustomerLastName());
			preference.setCustomerMiddleName(customer.getCustomerMiddleName());
			preference.setCustomerType(customer.getCustomerType());
			
			preferences.add(preference);
		}
		return preferences;
	}
	
	public static List<CustomerBookingHistory> parseCustomerBookingHistory(String inputJsn, Customer customer) throws Exception {
		
		log.info("In CustomerBookingHistory Util:parseCustomerBookingHistory");
		
		List<CustomerBookingHistory> bookingHistory = new ArrayList<>();
		
		JSONObject json = JsonUtils.getJson(inputJsn);
		
		JSONArray jsonArr = json.getJSONArray("bookingHistory");
 
		for(int i=0; i<jsonArr.length(); i++) {
			
			JSONObject bookingHistoryJson = (JSONObject) jsonArr.get(i);
			CustomerBookingHistory customerBookingHistory = mapper.readValue(bookingHistoryJson.toString(), CustomerBookingHistory.class);
			customerBookingHistory.setCustomerId(customer.getCustomerId());
			customerBookingHistory.setCustomerFirstName(customer.getCustomerFirstName());
			customerBookingHistory.setCustomerLastName(customer.getCustomerLastName());
			customerBookingHistory.setCustomerMiddleName(customer.getCustomerMiddleName());
			customerBookingHistory.setCustomerType(customer.getCustomerType());
			
			bookingHistory.add(customerBookingHistory);
		}
		
		return bookingHistory;
	}

	public static CustomerPersonalityTrait parseCustomerPersonalityTraits(String inputJsn, Customer customer) throws Exception {
		
		log.info("In Customer Personality Traits Util:parseCustomerPersonalityTraits");

		JSONObject json = JsonUtils.getJson(inputJsn);
		JSONObject personalityJson = json.getJSONObject("personalityTraits");
		
		CustomerPersonalityTrait personalityTraits = mapper.readValue(personalityJson.toString(), CustomerPersonalityTrait.class);
		personalityTraits.setCustomerId(customer.getCustomerId());
		personalityTraits.setCustomerFirstName(customer.getCustomerFirstName());
		personalityTraits.setCustomerLastName(customer.getCustomerLastName());
		personalityTraits.setCustomerMiddleName(customer.getCustomerMiddleName());
		personalityTraits.setCustomerType(customer.getCustomerType());
		
		return personalityTraits;
	}

}
