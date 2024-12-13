package Hemanth.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Hemanth.AbstarctCompo.AbstarctComponents;

public class ConfirmationPageNeww extends AbstarctComponents {

	WebDriver driver;
	
	public ConfirmationPageNeww(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".hero-primary")
	WebElement finalMessage;
	
	public String getConfirmationMsg()
	{
		return finalMessage.getText();
	}



}
