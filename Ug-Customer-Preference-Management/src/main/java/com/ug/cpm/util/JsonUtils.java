package com.ug.cpm.util;

import org.json.JSONObject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtils {

	public static final JSONObject getJson(String input) {

		log.info("input json : "+ input);

		JSONObject json = new JSONObject();

		try {
			if(input !=null && input.length() > 0)
			{
				log.info("input json is present");
				json = new JSONObject(input);
				log.info("json : "+ json);
			}
		}
		catch(Exception e) {

			log.error("Exception in converting string to JSONObject! "+ e);
		}

		return json;
	}
}
