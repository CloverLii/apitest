package util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class FileReaderUtil {
		
	public JSONObject readFromJson(String jsonFilePath) throws IOException, FileNotFoundException, ParseException{
		
		JSONParser jsonParser = new JSONParser();
		// read json file from local
		FileReader reader = new FileReader(jsonFilePath);
		Object obj = jsonParser.parse(reader);		
		// parse context to JSON Object
		JSONObject jsonObj = (JSONObject)obj;
				
		return jsonObj;	
	}
	
	//TODO: read from excel
	//TODO: read from ymal file
}
