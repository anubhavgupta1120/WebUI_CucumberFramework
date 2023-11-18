package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OfferPage {

	WebDriver driver;

	public OfferPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@type = 'search']")
	private WebElement searchBoxElement;
	@FindBy(how = How.XPATH, using = "//tbody//td[1]")
	private WebElement productNameElement;

	public void searchProduct(String name) {
		searchBoxElement.sendKeys(name, Keys.ENTER);
	}

	public String getProductName() {
		return productNameElement.getText();
	}

}
