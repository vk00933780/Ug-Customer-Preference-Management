package com.ug.cpm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "T_CPM_CustomerPersonalityTrait")
public class CustomerPersonalityTraits {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", nullable = false)
	private int id;
	
	@Column(name = "Customer_Id", nullable = false)
	private int customerId;
	
	@Column(name = "Customer_Firstname")
	private String customerFirstName;
	
	@Column(name = "Customer_Lastname")
	private String customerLastName;
	
	@Column(name = "Customer_Middlename")
	private String customerMiddleName;
	
	@Column(name = "Customer_Type")
	private String customerType;
	
	@Column(name = "Personality")
	private String personality;
	
	@Column(name = "Habits")
	private String habits;
	
	@Column(name = "Emotions")
	private String emotions;
	
	@Column(name = "Created_On")
	private String createdDate;
	
	@Column(name = "Last_Updated_On")
	private String updatedDate;
}
