package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
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
	
	private static Logger log = LoggerFactory.getLogger(FormatConverter.class);
	
	// convert VideoGame object to Json string
	public static String obj2Json(VideoGame vg) throws JsonProcessingException {
		
		//String jsonStr = new ObjectMapper().writeValueAsString(vg);
		
		// show values in a more readable style
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String jsonStr = ow.writeValueAsString(vg);
		System.out.println("...VideoGame object to json: " + jsonStr);
		return jsonStr;		
	}
	
	// convert Json string to Json object
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
