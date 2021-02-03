package listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;

import testcases.BaseTest;
import util.PropertiesReader;

/**
 * 
 * @author cloverli
 * @date 31/01/2021
 *
 */
public class FailedRetryRunner implements IRetryAnalyzer{
	
	static Logger log = Logger.getLogger(FailedRetryRunner.class);
	
	private int retryCount = 0;
	
	// get 'maxRetryCount' from config.properties file
	private static final int maxRetryCount = Integer.parseInt(PropertiesReader.getKey("conf.maxRetryCount"));

	public boolean retry(ITestResult iTestResult) {
		if (retryCount < maxRetryCount) {
			retryCount++;
			log.info(String.format("====retry failed test: %d", retryCount));
			return true;
		} else {
			return false;
		}
	}
}
