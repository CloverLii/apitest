package util;

import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Random;

public class DataBuilder {
		
	public static Integer getId(int currentMaxId) {
		return currentMaxId + 1;
	}
	
	// TODO: generate meaningful category name, like random value in list
	public static String getName() {
		int numberLength = new Random().nextInt(8) + 1;
		return ( "name_" + RandomUtil.getRandom(numberLength, false));
	}
	
	// TODO: generate meaningful category name, like random value in list
	public static String getCategoryName() {
		int numberLength = new Random().nextInt(8) + 1;
		return ( "category_" + RandomUtil.getRandom(numberLength, false));
	}
	
	// TODO: generate meaningful rating, like random value in list
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
		//Timestamp timestamp = new Timestamp(Math.abs(System.currentTimeMillis() - rnd.nextLong()));
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return (sdf.format(timestamp));
	}
	
}
