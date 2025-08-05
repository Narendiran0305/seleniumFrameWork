package PageClasses;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class testCasePage4 {

	WebDriver driver;
	public testCasePage4(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//textarea[@title='Search']")
	WebElement searchBox;
	
	
	public void searchGoogle(String searchtext)
	{
		searchBox.sendKeys(searchtext);
	}
	
	
	
}
