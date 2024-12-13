package Hemanth.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Hemanth.AbstarctCompo.AbstarctComponents;

public class LandingPageNeww extends AbstarctComponents {

	WebDriver driver;

	public LandingPageNeww(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement userEmail = driver.findElement(By.id("userEmail"));

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement passwordEle;

	@FindBy(id = "login")
	WebElement submit;
	
	@FindBy(xpath = "//div[@aria-label='Incorrect email or password.']")
	WebElement errorMessage;

	public ProductCatalogueNew loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();

		ProductCatalogueNew productCat = new ProductCatalogueNew(driver);
		return productCat;

	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMessage()
	{
		waitForElementToAppearDriver(errorMessage);
		return errorMessage.getText();
	}

}
