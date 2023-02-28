package com.ug.cpm.dto;

import static com.ug.cpm.util.ParseValueUtils.intValue;
import static com.ug.cpm.util.ParseValueUtils.stringValue;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

	private int customerId;
	private String customerFirstName;
	private String customerLastName;
	private String customerMiddleName;
	private String preferredName;
	private String primaryContactNumber;
	private String secondaryContactNumner;
	private String address;
	private String emailId;
	private int age;
	private String dateOfBirth;
	private String gender;
	private String race;
	private String religion;
	private String maritalStatus;
	private String ethnicity;
	private String hobbies;
	private String customerType;
	private int primaryGuestId;
	private String primaryGuestRelationship;
	private String createdDate;
	private String updatedDated;

	CustomerPersonalityTraitDto personalityTraits;
	Set<CustomerPreferenceDto> preferences = new LinkedHashSet<>();
	Set<CustomerBookingHistoryDto> bookingHistory = new LinkedHashSet<>();

	public CustomerDto(Object[] tuple, Map<String, Integer> aliasToIndexMap) {

		this.customerId = intValue(tuple, aliasToIndexMap, "customerId");
		this.customerFirstName = stringValue(tuple, aliasToIndexMap, "customerFirstName");
		this.customerLastName = stringValue(tuple, aliasToIndexMap, "customerLastName"); 
		this.customerMiddleName = stringValue(tuple, aliasToIndexMap, "customerMiddleName");
		
		this.preferredName = stringValue(tuple, aliasToIndexMap, "preferredName");
		this.primaryContactNumber = stringValue(tuple, aliasToIndexMap, "primaryContactNumber"); 
		this.secondaryContactNumner = stringValue(tuple, aliasToIndexMap, "secondaryContactNumner");
		
		this.address = stringValue(tuple, aliasToIndexMap, "address");
		this.emailId = stringValue(tuple, aliasToIndexMap, "emailId"); 
		this.age = intValue(tuple, aliasToIndexMap, "age");
		
		this.dateOfBirth = stringValue(tuple, aliasToIndexMap, "dateOfBirth");
		this.gender = stringValue(tuple, aliasToIndexMap, "gender"); 
		this.race = stringValue(tuple, aliasToIndexMap, "race");
		
		this.religion = stringValue(tuple, aliasToIndexMap, "religion");
		this.maritalStatus = stringValue(tuple, aliasToIndexMap, "maritalStatus"); 
		this.ethnicity = stringValue(tuple, aliasToIndexMap, "ethnicity");
		
		this.hobbies = stringValue(tuple, aliasToIndexMap, "hobbies");
		this.primaryGuestId = intValue(tuple, aliasToIndexMap, "primaryGuestId"); 
		this.primaryGuestRelationship = stringValue(tuple, aliasToIndexMap, "primaryGuestRelationship");
		
		this.createdDate = stringValue(tuple, aliasToIndexMap, "createdDate");
		this.updatedDated = stringValue(tuple, aliasToIndexMap, "updatedDated"); 
		
	}
}
