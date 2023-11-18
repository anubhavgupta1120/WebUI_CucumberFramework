package BaseTestUtils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utils.GenericResource;

public class BaseTest {
	private WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {
		String browserName = GenericResource.getProperty("Browser");
		if (driver == null) 
		{
			if(browserName.contains("chrome")) {
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			}
		}
		return driver;
	}
}
