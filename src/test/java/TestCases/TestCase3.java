package TestCases;

import java.io.File;
import java.io.IOException;
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
public class TestCase3 {

	WebDriver driver;

	@BeforeTest
	public void launchbrower() {
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\Narendiran\\eclipse-workspace\\Seleniumrefresh\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
//	    options.addArguments("--window-size=1920,1080"); 
		driver = new ChromeDriver(options);

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

	}

	@AfterTest
	public void closebrowser() {
		driver.quit();
	}

	@Test
	public void windowHandleTest() throws InterruptedException, IOException {
		String parentWindow = driver.getWindowHandle();
		WebElement logo = driver.findElement(By.className("logoClass"));
		File src = logo.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Narendiran\\eclipse-workspace\\TestNGFrameworkRefresh\\screenshot.png");
		FileUtils.copyFile(src, dest);
		driver.findElement(By.id("openwindow")).click();
		Thread.sleep(2000);
		driver.switchTo().window(parentWindow);
		Thread.sleep(2000);
		driver.findElement(By.id("opentab")).click();
		Thread.sleep(2000);
		driver.switchTo().window(parentWindow);
		Thread.sleep(2000);

		Set<String> windowHandles = driver.getWindowHandles();
		for (String window : windowHandles) {
			driver.switchTo().window(window);
			System.out.println("Switched to tab " + driver.getWindowHandle());
			Thread.sleep(2000);
		}
	}

	@Test(enabled = false)
	public void framesTest() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement iFrame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("courses-iframe")));
		driver.switchTo().frame(iFrame);
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		driver.findElement(By.className("theme-btn")).click();
		Thread.sleep(2000);
	}

	@Test(enabled = false)
	public void webTableTest() {
		WebElement table = driver.findElement(By.className("tableFixHead"));

		// Get all rows (excluding header)
		List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));

			for (WebElement cell : cells) {
				System.out.print(cell.getText() + " ");
			}
			System.out.println();
		}

		System.out.println("Executed on: " + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()));

	}
}
