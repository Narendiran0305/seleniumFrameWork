package TestCases;

import org.testng.annotations.*;

@Listeners(ListenerClass.class)
public class TestCase1 extends BaseClass {

	@Test
	public void googleTest() {
		driver.get("https://google.com/");
	}

	@Test
	public void googleTest1() {
		driver.get("https://google.com/");
	}
}
