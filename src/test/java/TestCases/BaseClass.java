package TestCases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class BaseClass {

	protected WebDriver driver;
	
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("target/extent-reports/extent-report.html");
	ExtentTest test;
	
	@BeforeSuite
	public void suiteSetup()
	{
		spark.config().setDocumentTitle("Test Report Document");
		spark.config().setReportName("Test Report");
		extent.attachReporter(spark);
	}
	
	@AfterSuite
	public void suiteTeardown()
	{
		extent.flush();
	}
	
	
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
