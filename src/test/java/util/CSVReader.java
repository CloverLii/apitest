package util;

import java.io.FileNotFoundException;
import java.io.FileReader;


/**
 * Handle test cases which organized in testcases.csv file
 * @author cloverdolphin
 * @date 03/02/2021
 *
 */
public class CSVReader {
	
	public static void readCSV(String csvPath) throws FileNotFoundException {
		FileReader reader = new FileReader(csvPath);
		
		//TODO: read test cases from template csv file
	}
}
