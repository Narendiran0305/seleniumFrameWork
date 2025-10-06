package TestCases;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.*;

@Listeners(ListenerClass.class)
public class TestCase1 extends BaseClass {

	@Test
	public void googleTest() {
		test = extent.createTest("test1");
		test.info("Test1 started");
		driver.get("https://google.com/");
		test.info("reached the test page");
		test.pass("Test1 Passed");
		String screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(screenshot);
		
		test.info("Test1 ended");
	}

	@Test
	public void googleTest1() {
		driver.get("https://google.com/");
	}
}
