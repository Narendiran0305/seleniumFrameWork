package TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseClass {

	protected WebDriver driver;

	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) {
		DriverManager.setDriver(browser);
		driver = DriverManager.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	}

	@AfterMethod
	public void tearDown() {
		DriverManager.quitDriver();
	}
}
