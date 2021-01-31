package listener;

import org.testng.ITestResult;
import util.PropertiesReader;

/**
 * 
 * @author cloverli
 * @date 31/01/2021
 *
 */
public class FailedRetryRunner {
	
	private int retryCount = 0;
	private static final int maxRetryCount = Integer.parseInt(PropertiesReader.getKey("conf.maxRetryCount"));

	public boolean retry(ITestResult iTestResult) {
		if (retryCount < maxRetryCount) {
			retryCount++;
			return true;
		} else {
			return false;
		}
	}
}
