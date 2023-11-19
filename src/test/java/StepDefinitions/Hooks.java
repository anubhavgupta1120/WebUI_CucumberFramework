package StepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import Utils.TestSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;

public class Hooks {
	TestSetup parent;

	public Hooks(TestSetup parent) {
		this.parent = parent;
	}

	@After
	public void teardown() throws IOException {
		parent.baseTest.WebDriverManager().quit();
	}

	@AfterStep
	public void addScreenShot(io.cucumber.java.Scenario scenario) throws WebDriverException, IOException {
		if (scenario.isFailed()) {
			File sourcePath = ((TakesScreenshot) parent.baseTest.WebDriverManager()).getScreenshotAs(OutputType.FILE);
			byte[] content = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(content, "image/png", "image");

		}
	}
}
