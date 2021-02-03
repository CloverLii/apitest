package util;

import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import java.util.Random;
import org.testng.log4testng.Logger;


/**
 * 
 * Generate predefined random values for testing
 * @author cloverdolphin
 * @date 03/02/2021
 *
 */
public class DataBuilder {
	
	static Logger log = Logger.getLogger(DataBuilder.class);
	
	// create unique id for new video game
	public static Integer getId(int currentMaxId) {
		return currentMaxId + 1;
	}
	
	public static String getName() {
		int numberLength = new Random().nextInt(8) + 1;
		return ( "name_" + RandomUtil.getRandom(numberLength, false));
	}
	
	public static String getCategoryName() {
		int numberLength = new Random().nextInt(8) + 1;
		return ( "category_" + RandomUtil.getRandom(numberLength, false));
	}
	
	public static String getRating() {
		int numberLength = new Random().nextInt(8) + 1;
		return ( "rating_" + RandomUtil.getRandom(numberLength, false));
	}
	
	// generate random review score from 1 to 99
	public static Integer getReviewScore() {
		
		int numberLength = new Random().nextInt(2) + 1;
		return Integer.parseInt(RandomUtil.getRandom(numberLength, true));
	}
	
	// format: 2005-10-01T00:00:00+12:00
	public static String getReleaseDate() {
		
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		
		Random rnd = new Random();
		Timestamp timestamp = new Timestamp(Math.abs(System.currentTimeMillis() - rnd.nextLong()));
		//Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return (sdf.format(timestamp));
	}
	
}
