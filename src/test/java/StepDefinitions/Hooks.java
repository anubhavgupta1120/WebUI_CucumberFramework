package StepDefinitions;

import java.io.IOException;

import Utils.TestSetup;
import io.cucumber.java.After;

public class Hooks {
	TestSetup parent;

	public Hooks(TestSetup parent) {
		this.parent = parent;
	}

	@After
	public void teardown() throws IOException {
		parent.baseTest.WebDriverManager().quit();
	}
}
