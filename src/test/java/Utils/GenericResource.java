package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericResource {

	private WebDriver driver;

	public GenericResource(WebDriver driver) {
		this.driver = driver;
	}

	public void goToChildWindow(String UniqueUrlContains) {

		String parentId = driver.getWindowHandle();
		Set<String> WindowId = driver.getWindowHandles();

		for (String id : WindowId) {
			if (!id.equalsIgnoreCase(parentId)) {
				driver.switchTo().window(id);
				if (driver.getCurrentUrl().contains(UniqueUrlContains)) {
					break;
				}
			}
		}
	}

	public static String getProperty(String Key) throws IOException {
		FileInputStream FIS = new FileInputStream(
				"/Users/anubhavgupta/Documents/eclipse-workspace(Java)/UI_CucumberFramework/src/test/resources/GlobalData.properties");
		Properties prop = new Properties();
		prop.load(FIS);
		return prop.getProperty(Key);

	}

	public List<String> convertToList(String data) {
		String[] dataValue = data.split(",");
		return Arrays.asList(dataValue);
	}

}
