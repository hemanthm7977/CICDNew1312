package Hemanth.TestComponent;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryNew implements IRetryAnalyzer {

	int count = 0;
	int maxTry = 2;

	public boolean retry(ITestResult result) {

		if (count < maxTry) {
			count++;
			return true;
		}

		return false;
	}

}
