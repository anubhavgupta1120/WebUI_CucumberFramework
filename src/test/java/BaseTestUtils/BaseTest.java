package BaseTestUtils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utils.GenericResource;

public class BaseTest {
	private WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {
		String browserName = System.getProperty("Browser") != null ? System.getProperty("Browser")
				: GenericResource.getProperty("Browser");
		if (driver == null) {
			if (browserName.contains("Chrome")) {
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			}
			if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			}
			if (browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
				driver.manage().window().maximize();
			}
		}
		return driver;
	}
}
