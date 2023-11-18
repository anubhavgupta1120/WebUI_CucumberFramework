package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectsManager {
	private HomePage homePage;
	private OfferPage offerPage;
	private CartPage cartPage;
	private CheckoutPage checkoutPage;
	private ConfirmationPage confirmationPage;
	WebDriver driver;

	public PageObjectsManager(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage getHomePage() {
		homePage = new HomePage(driver);
		return homePage;
	}

	public OfferPage getOfferPage() {
		offerPage = new OfferPage(driver);
		return offerPage;
	}

	public CartPage getCartPage() {
		cartPage = new CartPage(driver);
		return cartPage;
	}

	public CheckoutPage getCheckoutPage() {
		checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}

	public ConfirmationPage getConfirmationPage() {
		confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
	}
}
