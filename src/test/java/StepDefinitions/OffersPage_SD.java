package StepDefinitions;

import static org.testng.Assert.assertEquals;

import Utils.TestSetup;
import io.cucumber.java.en.Then;

public class OffersPage_SD {
	// All common variable of All SD move to the TestSetup
	String offersPageProductName = "";
	TestSetup parent;

	public OffersPage_SD(TestSetup parent /*
											 * This is the refrence of TestSetup class through this we assign all the
											 * common variable like parent.anyCommonVariableName
											 */) {
		this.parent = parent;
	}

	@Then("^User searched with same Shortname (.+) in offers page$")
	public void user_searched_for_same_tom_in_offers_page_to_check_if_product_exist_with_same_name(String ShortName) {
		parent.homePage.ClickOffersPage();
		parent.genericResource.goToChildWindow("offers");
		parent.offerPage = parent.pageObjectsManager.getOfferPage();
		parent.offerPage.searchProduct(ShortName);
		offersPageProductName = parent.offerPage.getProductName();
	}

	@Then("^Validate product name in Offers page matches with Home page$")
	public void validate_product_name_in_Offers_page_matches_with_Home_page() {
		assertEquals(offersPageProductName, parent.HomePageProductName);
	}
}
