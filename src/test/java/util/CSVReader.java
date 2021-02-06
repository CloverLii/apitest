package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Handle test cases which organized in testcases.csv file
 * @author cloverdolphin
 * @date 03/02/2021
 *
 */
public class CSVReader{
	
	private static Logger log = LoggerFactory.getLogger(CSVReader.class);
	
	public static void readCSV(String csvPath) {
		
		String line = "";
		String splitBy = ",";
		try {
			// parse csv file into BufferedReader object	
			BufferedReader br = new BufferedReader(new FileReader(csvPath));
			while((line = br.readLine())!= null) {
				// TODO: update based on actual requirement
				String[] videoGame = line.split(splitBy);
				log.info("==== content of test data: %s", videoGame.toString());
			}
			br.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
