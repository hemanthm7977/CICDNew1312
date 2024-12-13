package Hemanth.Testss;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import Hemanth.PageObjects.CartPage;
import Hemanth.PageObjects.CheckOutPageNew;
import Hemanth.PageObjects.ConfirmationPageNeww;
import Hemanth.PageObjects.ProductCatalogueNew;
import Hemanth.TestComponent.BaseTestNew;
//import Hemanth.TestComponent.*;

public class ErrorValidationssNeww extends BaseTestNew {

	@Test(groups = { "ErrorHandlingNew" }, retryAnalyzer = Hemanth.TestComponent.RetryNew.class)
	public void LoginErrorValidation() throws IOException {

		ProductCatalogueNew productCat = landingpage.loginApplication("hemanthm797@gmail.com", "Heman12*");
		String error = landingpage.getErrorMessage();
		// System.out.println(error);

		Assert.assertEquals("Incorrect email or password.", error);

		System.out.println("L:ogin Page Error Validation");

	}

	@Test
	public void ProductErrorValidation() throws IOException {

		String productName = "IPHONE 13 PRO";

		ProductCatalogueNew productCat = landingpage.loginApplication("hemanthm797@gmail.com", "Hemanth12*");

		List<WebElement> products = productCat.getProductList();

		productCat.addProductToCart(productName);

		CartPage cartpage = productCat.goToCartPage();

		boolean matchValue = cartpage.toVerifyTheProductName("XYZ");

		Assert.assertFalse(matchValue);

		System.out.println("Product Page Error Validation");

	}

}
