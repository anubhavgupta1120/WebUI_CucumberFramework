package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private By searchBoxElement = By.xpath("//input[@type = 'search']");
	private By productNameElement = By.xpath("//h4[1]");
	private By offerPageElement = By.xpath("//a[@href = '#/offers']");

	@FindBy(how = How.CSS, using = "a.cart-icon")
	private WebElement cartElement;

	@FindBy(how = How.XPATH, using = "(//div[@class = 'action-block'])[1]")
	private WebElement proceedToCheckOut;

	@FindBy(how = How.CSS, using = "h4.product-name")
	private List<WebElement> productNameList;

	@FindBy(how = How.XPATH, using = "//div[@class = 'product-action']/button")
	private List<WebElement> addToCartButtonList;

	@FindBy(how = How.XPATH, using = "//div[@class = 'stepper-input']/a[@class = 'increment']")
	private List<WebElement> incrementQuantity;

	public void searchProduct(String name) {
		driver.findElement(searchBoxElement).sendKeys(name, Keys.ENTER);
	}

	public String getProductName() {
		return driver.findElement(productNameElement).getText().split("-")[0].trim();
	}

	public void ClickOffersPage() {
		driver.findElement(offerPageElement).click();
	}

	public void goToBaseUrl() {
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}

	public void openCart() {
		cartElement.click();
		proceedToCheckOut.click();
	}

	public void addProductToCart(List<String> products, int Quantity) {
		for (int i = 0; i < productNameList.size(); i++) {
			String formatedProductName = productNameList.get(i).getText().split("-")[0].trim();
			int count = 0;
			if (products.contains(formatedProductName)) {
				count++;
				for (int j = 1; j < Quantity; j++) {
					incrementQuantity.get(i).click();
				}
				addToCartButtonList.get(i).click();
				if (count == products.size()) {
					break;
				}
			}
		}
	}

}
