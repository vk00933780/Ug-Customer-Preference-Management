package com.ug.cpm.util;

import java.util.Map;

public class ParseValueUtils {


	public static int intValue(Object[] tuples, Map<String, Integer> aliasToIndexMap, String attribute) {
		
		Object o = tuples[aliasToIndexMap.get(attribute)];
		
		return isNumber(o)?Integer.parseInt(o.toString()):0;
	}

	public static String stringValue(Object[] tuples, Map<String, Integer> aliasToIndexMap, String attribute) {
		
		Object o = tuples[aliasToIndexMap.get(attribute)];
		return o!=null?String.valueOf(o):null;
	}
	
	public static boolean booleanValue(Object[] tuples, Map<String, Integer> aliasToIndexMap, String attribute) {
		
		boolean value = false;
		Object o = tuples[aliasToIndexMap.get(attribute)];
		
		if(o != null) {
			String s = String.valueOf(o);
			
			if("Y".equalsIgnoreCase(s) || "Yes".equalsIgnoreCase(s) || "true".equalsIgnoreCase(s) || "T".equalsIgnoreCase(s))
				value = true;
			else
				value = false;
		}
	
		return value;
	}
	
	public static boolean isNumber(Object o) {
		try {
			Integer.parseInt(o.toString());
		}
		catch(Exception e) {
			return false;
		}

		return true;
	}

}
