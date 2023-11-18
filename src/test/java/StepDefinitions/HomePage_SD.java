package StepDefinitions;

import Utils.TestSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HomePage_SD {
	TestSetup parent;

	public HomePage_SD(TestSetup parent) {
		this.parent = parent;
	}

	@Given("User is on GreenKart Home Page")
	public void user_is_on_green_kart_landing_page() {
		parent.homePage = parent.pageObjectsManager.getHomePage();
		parent.homePage.goToBaseUrl();

	}

	@When("^User searched with Shortname (.+) in Home page and extracted actual name of the product$")
	public void user_searched_with_shortname_tom_and_extracted_actual_name_of_the_product(String ShortName) {
		parent.homePage.searchProduct(ShortName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parent.HomePageProductName = parent.homePage.getProductName();

	}
	
	@When("^User added products (.+) with each having quantity (.+) into the cart$")
	public void user_added_products_into_the_cart(String products, int quantity) throws InterruptedException {
	    parent.homePage.addProductToCart(parent.genericResource.convertToList(products),quantity);
	    Thread.sleep(2000);
	    parent.homePage.openCart();
	}
}
