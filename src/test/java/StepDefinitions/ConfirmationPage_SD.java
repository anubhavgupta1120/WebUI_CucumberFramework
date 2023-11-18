package StepDefinitions;

import static org.testng.Assert.assertTrue;

import Utils.TestSetup;
import io.cucumber.java.en.Then;

public class ConfirmationPage_SD {
	TestSetup parent;
	public ConfirmationPage_SD(TestSetup parent) {
		this.parent = parent;
	}
	
	@Then("^(.+) should be displayed on the Confirmation Page$")
	public void should_be_displayed_on_the_confirmation_page(String expectedText) throws InterruptedException {
		Thread.sleep(2000);
	    parent.confirmationPage = parent.pageObjectsManager.getConfirmationPage();
	    assertTrue(parent.confirmationPage.getConfirmationText().contains(expectedText));
	}

}
