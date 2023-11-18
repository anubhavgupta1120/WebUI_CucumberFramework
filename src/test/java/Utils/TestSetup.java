package Utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
// This File have all the common state of both SD classes so that we can share info from one SD class to Another
// To use this create a construct on both SD class and you can assign values of all the common methods
// for example:   see @HomePage_SD and @OfferPage_SD

import BaseTestUtils.BaseTest;
import PageObjects.CartPage;
import PageObjects.CheckoutPage;
import PageObjects.ConfirmationPage;
import PageObjects.HomePage;
import PageObjects.OfferPage;
import PageObjects.PageObjectsManager;

public class TestSetup {
	public WebDriver driver;
	public String HomePageProductName = "";
	public PageObjectsManager pageObjectsManager;
	public OfferPage offerPage;
	public HomePage homePage;
	public CartPage cartPage;
	public ConfirmationPage confirmationPage;
	public CheckoutPage checkoutPage;
	public BaseTest baseTest;
	public GenericResource genericResource;

	public TestSetup() throws IOException {
		baseTest = new BaseTest();
		this.pageObjectsManager = new PageObjectsManager(baseTest.WebDriverManager());
		this.genericResource = new GenericResource(baseTest.WebDriverManager());
	}
}
