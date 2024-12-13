package Hemanth.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Hemanth.AbstarctCompo.AbstarctComponents;

public class ProductCatalogueNew extends AbstarctComponents {

	WebDriver driver;

	public ProductCatalogueNew(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	By productBy = By.cssSelector(".mb-3");
	By addCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	By animatingMessage = By.cssSelector(".ng-animating");

	public List<WebElement> getProductList() {
		waitForElementToAppear(productBy);
		return products;
	}

	public WebElement getProductByName(String productName) {
		WebElement prod = getProductList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);

		return prod;
	}

	public void addProductToCart(String productName) {

		WebElement prod = getProductByName(productName);
		prod.findElement(addCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToAppear(animatingMessage);
		waitForElementToDisappear(spinner);

	}

}
