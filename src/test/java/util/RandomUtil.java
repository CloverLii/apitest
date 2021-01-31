package util;
import java.util.Random;

/**
 * 
 * @reference https://github.com/CloverLii/ApiAutoTest/blob/master/src/main/java/com/iiaccount/utils/RandomUtil.java
 * @author cloverli
 * @date 31/01/2021
 *
 */
public class RandomUtil {

	// contains all numbers and all characters
    private static String randomBase = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static String randomNumberBase = "0123456789";
    // TODO: random base containing special characters for specific content

    private static Random random = new Random();

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
            } while (i==0&&chr=='0') ;//第一个字符不能为0,

            sb.append(chr);
        }
        return sb.toString();
    }
}
