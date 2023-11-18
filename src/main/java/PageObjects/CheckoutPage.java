package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
	
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.XPATH, using = "//select")
	private WebElement selectCountryElement;
	@FindBy(how = How.CSS, using = ".chkAgree")
	private WebElement termsAndConditionsElement;
	@FindBy(how = How.XPATH, using = "//button[text() = 'Proceed']")
	private WebElement proceedElement;
	
	public void proceedToCheckout(String country) {
		Select select = new Select(selectCountryElement);
		select.selectByValue(country);
		termsAndConditionsElement.click();
		proceedElement.click();
	}
}
