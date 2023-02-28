package com.ug.cpm.dto;

import static com.ug.cpm.util.ParseValueUtils.intValue;
import static com.ug.cpm.util.ParseValueUtils.stringValue;
import java.util.Map;

import com.ug.cpm.util.ParseValueUtils;

import lombok.Data;

@Data
public class CustomerPersonalityTraitDto {

	
	 int customerId;
	 String personality;
     String habits;
     String emotions;
     //String createdDate;
     //String updatedDate;
     
     public CustomerPersonalityTraitDto(Object[] tuple, Map<String, Integer> aliasToIndexMap) {

    	 this.customerId = intValue(tuple, aliasToIndexMap, "customerId");
		 this.personality = stringValue(tuple, aliasToIndexMap, "personality"); 
		 this.habits =stringValue(tuple, aliasToIndexMap, "habits");  
		 this.emotions = stringValue(tuple, aliasToIndexMap, "emotions"); 
		// this.createdDate = stringValue(tuple, aliasToIndexMap, "createdDate"); 
		// this.updatedDate = stringValue(tuple, aliasToIndexMap, "updatedDate");
	
 	}
}
