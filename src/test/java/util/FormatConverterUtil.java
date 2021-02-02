package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FormatConverterUtil {
	
	// convert object to format json
	public static String obj2Json(VideoGame vg) throws JsonProcessingException {
		
		String jsonStr = new ObjectMapper().writeValueAsString(vg);		
		System.out.println("...object to json: " + jsonStr);
		return jsonStr;		
	}
}
