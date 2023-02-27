package com.ug.cpm.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@DynamicInsert
@DynamicUpdate
@Table(name = "T_CPM_BookingMaster")
public class CustomerBookingHistory {
	
	@Id
	@Column(name = "Booking_Id", nullable = false)
	private int bookingId;
	
	@Column(name = "Customer_Id", nullable = false)
	private int customerId;
	
	@Column(name = "Customer_Firstname")
	private String customerFirstName;
	
	@Column(name = "Customer_Lastname")
	private String customerLastName;
	
	@Column(name = "Customer_Middlename")
	private String customerMiddleName;
	
	@Column(name = "Customer_Category")
	private String customerCategory;
	
	@Column(name = "Customer_Type")
	private String customerType;
	
	@Column(name = "PrimaryGuest_Customer_Id")
	private int primaryGuestCustomerId;
	
	@Column(name = "PrimaryGuest_CustomerRelationship")
	private String primaryGuestCustomerRelationship;
	
	@Column(name = "Arrival_Date")
	private String arrivalDate;
	
	@Column(name = "Arrival_Time")
	private String arrivalTime;
	
	@Column(name = "Departure_Date")
	private String departureDate;
	
	@Column(name = "Departure_Time")
	private String departureTime;
	
	@Column(name = "Created_On")
	private String createdOn;
	
	@Column(name = "Last_Updated_On")
	private String lastUpdatedOn;
		
}
