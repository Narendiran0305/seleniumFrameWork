package TestCases;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(ListenerClass.class)
public class TestCase9 {

	WebDriver driver;

	@BeforeTest
	public void launchbrower() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);

		driver.get("https://www.booking.com/index.html?aid=2162441&label=pagehome-link-2162441-click&chal_t=1759376260118&force_referer=https%3A%2F%2Fin-en.flightnetwork.com%2F");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}

	@AfterTest
	public void closebrowser() {
		driver.quit();
	}

	@Test
	public void windowHandleTest(){
		System.out.println(driver.getTitle());
		
	//	List<WebElement> elements = driver
				.findElements(By.xpath("//h3[contains(text(),'Hotels')]/ancestor::ul//h3"));
		
		for(WebElement element : elements)
		{
			System.out.println(element.getText());
		}
				
	}

}
