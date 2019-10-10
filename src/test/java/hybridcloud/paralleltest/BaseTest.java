package hybridcloud.paralleltest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import hybridcloud.utils.DriverFactory;
import hybridcloud.utils.DriverType;

public class BaseTest {
 
	public WebDriver driver; 

	@BeforeTest
	public void setup() {
		driver = DriverFactory.getDriver(DriverType.CHROME);
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

	public void goToUrl(String url)
	{
		driver.get(url);
	}
}
