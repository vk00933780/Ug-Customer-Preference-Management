package com.ug.cpm.config;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.transform.ResultTransformer;

import com.ug.cpm.dto.CustomerBookingHistoryDto;
import com.ug.cpm.dto.CustomerDto;
import com.ug.cpm.dto.CustomerPersonalityTraitDto;
import com.ug.cpm.dto.CustomerPreferenceDto;

@SuppressWarnings("deprecation")
public class CustomerResultTransformer  implements ResultTransformer<CustomerDto>{
	
    private Map<Integer, CustomerDto> custDtoMap = new LinkedHashMap<>();
 
    @Override
    public CustomerDto transformTuple(
            Object[] tuple,
            String[] aliases) {
             
        Map<String, Integer> aliasToIndexMap = aliasToIndexMap(aliases);
        
        System.out.println("Tuples : ");
        
      /*  for(Object o : tuple)
        {
        	if(o !=null)
        		System.out.println("aliases Object : "+ o.toString());	
        }
        
        System.out.println("alies : ");
        
        for(String s : aliases)
        	System.out.println("aliases Object : "+ s.toString()); */
         
        int custId = Integer.parseInt(tuple[aliasToIndexMap.get("customerId")].toString());
 
        CustomerDto custDto = custDtoMap.computeIfAbsent(
        		custId,
            id -> new CustomerDto(tuple, aliasToIndexMap)
        );

        custDto.setPersonalityTraits(new CustomerPersonalityTraitDto(tuple, aliasToIndexMap));
        
        custDto.getBookingHistory().add(new CustomerBookingHistoryDto(tuple, aliasToIndexMap));
        
        custDto.getPreferences().add(new CustomerPreferenceDto(tuple, aliasToIndexMap));
        
        return custDto;
    }
    
    @Override
    public List<CustomerDto> transformList(List collection) {
        return new ArrayList<>(custDtoMap.values());
    }
 
    	
    public  Map<String, Integer> aliasToIndexMap(
            String[] aliases) {
         
        Map<String, Integer> aliasToIndexMap = new LinkedHashMap<>();
         
        for (int i = 0; i < aliases.length; i++) {
            aliasToIndexMap.put(aliases[i], i);
        }
         
        return aliasToIndexMap;
    }


}
