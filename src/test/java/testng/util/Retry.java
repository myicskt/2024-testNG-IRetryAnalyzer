package testng.util;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
public class Retry implements IRetryAnalyzer {
	private int retrycount =0;
	private final int maxcount=5;

	public boolean retry(ITestResult result) {
		if(retrycount<maxcount) {
			retrycount++;
			return true;
		}
		return false;
	}

}
