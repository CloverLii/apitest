package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * 
 * Convert file or content among different format
 * @author cloverli
 * @date 03/02/2021
 *
 */
public class FormatConverter {
	
	// convert VideoGame object to Json string
	public static String obj2Json(VideoGame vg) throws JsonProcessingException {
		
		//String jsonStr = new ObjectMapper().writeValueAsString(vg);
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String jsonStr = ow.writeValueAsString(vg);
		System.out.println("...VideoGame object to json: " + jsonStr);
		return jsonStr;		
	}
	
	public JSONObject readFromJson(String jsonFilePath) throws IOException, FileNotFoundException, ParseException{
			
			JSONParser jsonParser = new JSONParser();
			// read json file from local
			FileReader reader = new FileReader(jsonFilePath);
			Object obj = jsonParser.parse(reader);		
			// parse context to JSON Object
			JSONObject jsonObj = (JSONObject)obj;
					
			return jsonObj;	
		}
	
}
