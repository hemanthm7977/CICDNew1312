package Hemanth.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Hemanth.AbstarctCompo.AbstarctComponents;

public class OrderPageNeww extends AbstarctComponents {

	WebDriver driver;

	@FindBy(css = "tr td:nth-child(3)")
	List<WebElement> productListInOrders;

	public OrderPageNeww(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean toVerifyTheOrderPage(String productName) {
		boolean orderValue = productListInOrders.stream()
				.anyMatch(orderProduct -> orderProduct.getText().equalsIgnoreCase(productName));
		return orderValue;
	}

}
