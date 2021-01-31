package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


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
	
	public void readFromExcel(String excelFilePath) throws IOException, FileNotFoundException, ParseException{
		
		FileReader reader = new FileReader(excelFilePath);
	}
}
