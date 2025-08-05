package TestCases;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

@Listeners(ListenerClass.class)
public class TestCase2 extends BaseClass {

	@Test
	public void facebooktest() {
		driver.get("https://facebook.com/");
	}
	
}
