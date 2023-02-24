package com.ug.cpm.util;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ug.cpm.entity.Customer;
import com.ug.cpm.entity.CustomerPreference;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomerUtil {

	private static ObjectMapper mapper = new ObjectMapper();

	public static final Customer parseCustomer(String inputJsn) throws Exception {

		log.info("In Customer Util:parseCustomer");
		JSONObject json = getJson(inputJsn);

		Customer customer = mapper.readValue(json.toString(), Customer.class);
		log.info("customer : "+ customer.toString());
		return customer;
	}

	public static final List<CustomerPreference> parseCustomerPreference(String inputJsn, Customer customer) throws Exception {

		log.info("In CustomerPreference Util:parseCustomerPreference");
		
		List<CustomerPreference> preferences = new ArrayList<>();
		
		JSONObject json = getJson(inputJsn);
		
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

	public static final JSONObject getJson(String input) {

		log.info("input json : "+ input);

		JSONObject json = new JSONObject();

		try {
			if(input !=null && input.length() > 0)
			{
				log.info("input json is present");
				json = new JSONObject(input);
				log.info("json : "+ json);
			}
		}
		catch(Exception e) {

			log.error("Exception in converting string to JSONObject! "+ e);
		}

		return json;
	}
}
