package Hemanth.AbstarctCompo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Hemanth.PageObjects.CartPage;
import Hemanth.PageObjects.OrderPageNeww;

public class AbstarctComponents {

	WebDriver driver;

	@FindBy(css = "button[routerlink*='cart']")
	WebElement cartButton;

	@FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
	WebElement orderButton;

	public AbstarctComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitForElementToAppearDriver(WebElement ele1) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele1));
	}

	public void waitForElementToDisappear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	public CartPage goToCartPage() {
		cartButton.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}
	
	public OrderPageNeww goToOrderPage()
	{
		orderButton.click();
		OrderPageNeww orderpagenew = new OrderPageNeww(driver);
		return orderpagenew;
		
		
	}
}
