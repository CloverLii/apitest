package util;

import java.util.Random;
import org.testng.log4testng.Logger;

/**
 * 
 * @reference https://github.com/CloverLii/ApiAutoTest/blob/master/src/main/java/com/iiaccount/utils/RandomUtil.java
 * @author cloverli
 * @date 31/01/2021
 *
 */
public class RandomUtil {
	
	static Logger log = Logger.getLogger(RandomUtil.class);

	// contains all numbers and all characters
    private static String randomBase = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static String randomNumberBase = "0123456789";
    // TODO: randomBase containing special characters for certain content

    private static Random random = new Random();

    // create random value within certain length: number-only or combination of numbers and letters
    public static String getRandom(int length, boolean onlyNumber) {
        String base;
        if (onlyNumber) {
            base = randomNumberBase;
        } else {
            base = randomBase;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char chr;
            do {
                int number = random.nextInt(base.length());
                chr = base.charAt(number);
            } while (i==0&&chr=='0') ; // the first number of char could not be '0'

            sb.append(chr);
        }
        return sb.toString();
    }
}
