package com.ug.cpm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ug.cpm.dto.CustomerData;
import com.ug.cpm.entity.Customer;
import com.ug.cpm.entity.CustomerBookingHistory;
import com.ug.cpm.entity.CustomerPersonalityTrait;
import com.ug.cpm.entity.CustomerPreference;
import com.ug.cpm.entity.Preference;
import com.ug.cpm.repository.BookingHistoryRepository;
import com.ug.cpm.repository.CustomerPreferenceRepository;
import com.ug.cpm.repository.CustomerRepository;
import com.ug.cpm.repository.PersonalityTraitsRepository;
import com.ug.cpm.repository.PreferenceRepository;
import com.ug.cpm.util.CustomerUtil;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class NeomWebDataServiceImpl implements NeomWebDataService {
	
	private CustomerRepository customerRepository;
	private CustomerPreferenceRepository customerPreferenceRepository;
	private PreferenceRepository preferenceRepository;
	private PersonalityTraitsRepository personalityTraitsRepository;
	private BookingHistoryRepository bookingRepository;

	@Override
	public void saveCustomerData(String customerData) throws Exception {
		
		log.info("In Save Customer Data service");
		
		Customer customer = CustomerUtil.parseCustomer(customerData);
		List<CustomerPreference> customerPreferences = CustomerUtil.parseCustomerPreference(customerData, customer);
		List<CustomerBookingHistory> customerBookingHistory = CustomerUtil.parseCustomerBookingHistory(customerData, customer);
		CustomerPersonalityTrait customerPersonalityTraits = CustomerUtil.parseCustomerPersonalityTraits(customerData, customer);
		
		log.info("After parsing customer : "+ customer.toString());
		
		customerRepository.save(customer);
		
		//Checking whether preference is present in preference Master? if not then save it preference master
		for(CustomerPreference customerpref: customerPreferences) {
			
			if(!preferenceRepository.findById(customerpref.getPreferenceId()).isPresent())
			{
				Preference preference = new Preference();
				preference.setPreferenceId(customerpref.getPreferenceId());
				preference.setPreferenceType(customerpref.getPreferenceType());
				preference.setPreferenceName(customerpref.getPreferenceName());
				//preference.setPreferenceDescription(customerpref.getPreferenceDescription());
				preferenceRepository.save(preference);
			}	
		}
		
		personalityTraitsRepository.save(customerPersonalityTraits);
		bookingRepository.saveAll(customerBookingHistory);
		customerPreferenceRepository.saveAll(customerPreferences);
	}

	@Override
	public void saveAllCustomerData(String customersData) {
		
		List<Customer> customers = new ArrayList<>();
		
		customerRepository.saveAll(customers);
	}

	@Override
	public Customer updateCustomer(Customer customer, int customerId) throws Exception {
		
		Customer customerTemp = customerRepository.findById(customerId).get();
		
		if(customerTemp == null)
			throw new Exception("Customer with ID : "+ customerId + " not found!");
		
		return customerRepository.save(customer);

	}

	@Override
	public void deleteCustomer(int customerId) throws Exception {
		
		Customer customer = customerRepository.findById(customerId).get();
		
		if(customer == null)
			throw new Exception("Customer with ID : "+ customerId + " not found!");
		
		customerRepository.save(customer);

	}

	@Override
	public CustomerData getCustomer(int customerId) throws Exception {
		
		return customerRepository.getCustomerDataById(customerId);
	}

	@Override
	public List<CustomerData> getAllCustomer() {
		
		return customerRepository.getAllCustomerData();
	}

}
