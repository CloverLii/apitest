package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.testng.log4testng.Logger;

import testcases.BaseTest;

/***
 * 
 * Utility class: read and get the values of properties file
 * @author cloverli
 * @date 24/01/2021
 *
 */
public class PropertiesReader {
	
	static Logger log = Logger.getLogger(PropertiesReader.class);

	private static final Properties PROPERTIES = new Properties();
	
	private PropertiesReader() {}
	
	// read properties file from file path 
	public static Properties readProperties(String propertiesPath) throws IOException{
		
		InputStream inputStream = new FileInputStream(propertiesPath);
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		PROPERTIES.load(bufferedReader);
		return PROPERTIES;		
	}
	
	// get value of property
	public static String getKey(String key) {
		return PROPERTIES.getProperty(key);
	}
}
