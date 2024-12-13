package Hemanth.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Hemanth.AbstarctCompo.AbstarctComponents;

public class CartPage extends AbstarctComponents {

	WebDriver driver;

	@FindBy(xpath = "//div[@class='cartSection'] /h3")
	List<WebElement> cartProducts;

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkOutButton;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public boolean toVerifyTheProductName(String productName) {
		boolean matchValue = cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return matchValue;

	}

	public CheckOutPageNew clickCheckOutButton() {
		checkOutButton.click();
		
		CheckOutPageNew checkoutpagenew = new CheckOutPageNew(driver);
		return checkoutpagenew;
		
	}

}
