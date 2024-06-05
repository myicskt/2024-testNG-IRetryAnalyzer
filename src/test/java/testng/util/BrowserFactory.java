package testng.util;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BrowserFactory {
	WebDriver driver ;
	
	@Before
	public void init(){
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://google.com");
	}
	
	
	
	@Test
	public void test1() {
		Assert.assertTrue(true, "test case 1 is failed");
		
	}
	
	@Test
	public void test2() {
		Assert.assertTrue(false, "test case 2 is failed");
		
	}
	
	@Test
	//(retryAnalyzer=Retry.class)
	public void test3() {
		
		Assert.assertTrue(false, "test case 3 is failed");
		
	}
	
	/*
	 * only for specific test 
	@Test(retryAnalyzer=Retry.class)
	public void test3() {
		
		Assert.assertTrue(false, "test case 3 is failed");
		
	}
*/
	@After
	public void tearDown() {
		driver.quit();
	}

}
