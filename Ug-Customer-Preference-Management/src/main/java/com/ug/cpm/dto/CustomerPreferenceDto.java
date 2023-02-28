package com.ug.cpm.dto;

import static com.ug.cpm.util.ParseValueUtils.intValue;
import static com.ug.cpm.util.ParseValueUtils.stringValue;
import static com.ug.cpm.util.ParseValueUtils.booleanValue;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPreferenceDto {

	private int preferenceId;
	private int customerId;
	private String preferenceType;
	private String preferenceName;
	private String preferenceCreatedDate;
	private String preferenceUpdatedDate;
	private boolean isActive;
	private boolean isLike;

	public CustomerPreferenceDto(Object[] tuple, Map<String, Integer> aliasToIndexMap) {

		this.customerId = intValue(tuple, aliasToIndexMap, "customerId");
		this.preferenceId = intValue(tuple, aliasToIndexMap, "preferenceId");
		this.preferenceType = stringValue(tuple, aliasToIndexMap, "preferenceType"); 
		this.preferenceName =stringValue(tuple, aliasToIndexMap, "preferenceName");  
		this.preferenceCreatedDate = stringValue(tuple, aliasToIndexMap, "preferenceCreatedDate"); 
		this.preferenceUpdatedDate = stringValue(tuple, aliasToIndexMap, "preferenceUpdatedDate"); 
		this.isActive = booleanValue(tuple, aliasToIndexMap, "isActive");
		this.isActive = booleanValue(tuple, aliasToIndexMap, "isActive");
	}
}
