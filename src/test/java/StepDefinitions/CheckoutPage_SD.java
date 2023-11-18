package StepDefinitions;

import Utils.TestSetup;
import io.cucumber.java.en.When;

public class CheckoutPage_SD {
	
	TestSetup parent;
	
	public CheckoutPage_SD(TestSetup parent) {
		this.parent = parent;
	}
	
	@When("^User select country (.+) and perform checkout$")
	public void user_select_country_and_perform_checkout(String country) throws InterruptedException {
	    parent.cartPage = parent.pageObjectsManager.getCartPage();
	    Thread.sleep(2000);
	    parent.cartPage.placeOrder();
	    Thread.sleep(2000);
	    parent.checkoutPage = parent.pageObjectsManager.getCheckoutPage();
	    parent.checkoutPage.proceedToCheckout(country);
	    
	}

}
