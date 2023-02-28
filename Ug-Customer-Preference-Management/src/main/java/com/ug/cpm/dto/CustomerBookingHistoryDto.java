package com.ug.cpm.dto;

import static com.ug.cpm.util.ParseValueUtils.intValue;
import static com.ug.cpm.util.ParseValueUtils.stringValue;

import java.util.Map;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerBookingHistoryDto {

	private int bookingId;
	private int customerId;
	private String arrivalDate;
	private String arrivalTime;
	private String departureDate;
	private String departureTime;
	//private String createdOn;
	//private String lastUpdatedOn;

	public CustomerBookingHistoryDto(Object[] tuple, Map<String, Integer> aliasToIndexMap) {

		this.customerId = intValue(tuple, aliasToIndexMap, "customerId");
		this.bookingId = intValue(tuple, aliasToIndexMap, "bookingId");
		this.arrivalDate = stringValue(tuple, aliasToIndexMap, "arrivalDate"); 
		this.arrivalTime =stringValue(tuple, aliasToIndexMap, "arrivalTime");  
		this.departureDate = stringValue(tuple, aliasToIndexMap, "departureDate"); 
		this.departureTime = stringValue(tuple, aliasToIndexMap, "departureTime"); 
		//this.createdOn = stringValue(tuple, aliasToIndexMap, "createdOn");
		//this.lastUpdatedOn = stringValue(tuple, aliasToIndexMap, "lastUpdatedOn");

	}
}
