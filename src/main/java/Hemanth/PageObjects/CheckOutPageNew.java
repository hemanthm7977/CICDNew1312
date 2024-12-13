package Hemanth.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import Hemanth.AbstarctCompo.AbstarctComponents;

public class CheckOutPageNew extends AbstarctComponents {

	WebDriver driver;

	By countryResults = By.cssSelector(".ta-results");

	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement countryClick;

	@FindBy(css = ".action__submit")
	WebElement submitButton;

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement countryName;

	public CheckOutPageNew(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void countryClick(String countryNameS) {
		Actions ac = new Actions(driver);
		ac.sendKeys(countryName, countryNameS).build().perform();

		waitForElementToAppear(countryResults);

		countryClick.click();

	//	String finalMsg = finalMessage.getText();
	//	return finalMsg;

	}

	public ConfirmationPageNeww submitOrder() {

		submitButton.click();
		ConfirmationPageNeww confirmationpagenew = new ConfirmationPageNeww(driver);
		return confirmationpagenew;
	}

}
