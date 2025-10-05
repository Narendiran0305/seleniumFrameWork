package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import PageClasses.testCasePage4;

@Listeners(ListenerClass.class)
public class TestCase4 {

	WebDriver driver;
	testCasePage4 page;

	@Test
	public void googleTest() throws InterruptedException {
		driver.get("https://google.com/");
		page = new testCasePage4(driver);
		page.searchGoogle("iphone");
		Thread.sleep(5000);
	}

	@BeforeTest
	public void launchbrower() {
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\Narendiran\\eclipse-workspace\\Seleniumrefresh\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
//	    options.addArguments("--window-size=1920,1080"); 
		driver = new ChromeDriver(options);
	}

	@AfterTest
	public void closebrowser() {
		driver.quit();
	}
}
