package TestCases;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	int maxRetry = 2;
	int count = 0;

	@Override
	public boolean retry(ITestResult result) {
		if (maxRetry > count) {
			count++;
			return true;
		}
		return false;
	}
}
