package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FormatConverterUtil {
	
	// convert object to format json
	public static String obj2Json(Object obj) throws JsonProcessingException {
		
		String json = new ObjectMapper().writeValueAsString(obj);		
		System.out.println("...object to json: " + json);		
		return json;
	}
}
