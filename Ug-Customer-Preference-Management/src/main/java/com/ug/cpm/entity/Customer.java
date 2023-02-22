package com.ug.cpm.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "T_CPM_Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//private int id;
	@Column(name = "Customer_Id", nullable = false)
	private int customerId;
	@Column(name = "Customer_Firstname")
	private String customerFirstName;
	@Column(name = "Customer_Lastname")
	private String customerLastName;
	@Column(name = "Customer_Middlename")
	private String customerMiddleName;
	@Column(name = "Customer_Preferredname")
	private String preferredName;
	@Column(name = "Primary_Contactnumber")
	private String primaryContactNumber;
	@Column(name = "Secondary_Contactnumber")
	private String secondaryContactNumner;
	
	//Need to have a separate class for address
	@Column(name = "Address")
	private String address;
	@Column(name = "Email")
	private String emailId;
	@Column(name = "Customer_Age")
	private int age;
	@Column(name = "Customer_DOB")
	private String dateOfBirth;
	@Column(name = "Customer_Gender")
	private String gender;
	@Column(name = "Customer_Race")
	private String race;
	@Column(name = "Customer_Religion")
	private String religion;
	@Column(name = "Customer_Maritalstatus")
	private String maritalStatus;
	@Column(name = "Customer_Ethnicity")
	private String ethnicity;
	@Column(name = "Hobbies")
	private List<String> hobbies;
	@Column(name = "Customer_Type")
	private String customerType;
	@Column(name = "Customerid_Sourcesystem")
	private String sourceName;
	@Column(name = "Primaryguest_Customer_Id")
	private int primaryGuestId;
	@Column(name = "Primaryguest_Customerrelationship")
	private String primaryGuestRelationship;
	
	@Column(name = "Created_On")
	private String createdDate;
	@Column(name = "Last_Updated_On")
	private String updatedDated;
	
	@OneToMany
	private List<CustomerPreference> customerPreference;
	
	
}
