package Hemanth.Testss;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Hemanth.PageObjects.LandingPageNeww;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTestneww {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String productName = "IPHONE 13 PRO";
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		
		LandingPageNeww landingpage = new LandingPageNeww(driver);

		driver.findElement(By.id("userEmail")).sendKeys("hemanthm797@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Hemanth12*");

		driver.findElement(By.id("login")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);

		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();

		List<WebElement> cartProducts = driver.findElements(By.xpath("//div[@class='cartSection'] /h3"));

		boolean matchValue = cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));

		Assert.assertTrue(matchValue);

		driver.findElement(By.xpath("//button[text()='Checkout']")).click();

		Actions ac = new Actions(driver);
		ac.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "India").build().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();

		String finalMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();

		Assert.assertTrue(finalMessage.equalsIgnoreCase("Thankyou for the order."));

	}

}
