package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
	private static final String FIREFOX_DRIVER_PATH = System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe";

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(String browser) {
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
			driver.set(new ChromeDriver());
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH);
			driver.set(new FirefoxDriver());
		}
	}

	public static void quitDriver() {
		if (driver.get() != null) {
			driver.get().quit();
			driver.remove(); // clean up thread local to avoid memory leaks
		}
	}
}
