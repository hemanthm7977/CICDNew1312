package Hemanth.Testss;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Hemanth.PageObjects.CartPage;
import Hemanth.PageObjects.CheckOutPageNew;
import Hemanth.PageObjects.ConfirmationPageNeww;
import Hemanth.PageObjects.OrderPageNeww;
import Hemanth.PageObjects.ProductCatalogueNew;
import Hemanth.TestComponent.BaseTestNew;

public class SubmitOrderNeww extends BaseTestNew {

	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getDataNewww", groups = { "PurchaseOrder" })
	public void submitOrder(HashMap<String, String> input) throws IOException {

		ProductCatalogueNew productCat = landingpage.loginApplication(input.get("email"), input.get("password"));

		List<WebElement> products = productCat.getProductList();

		productCat.addProductToCart(input.get("productName"));

		CartPage cartpage = productCat.goToCartPage();

		boolean matchValue = cartpage.toVerifyTheProductName(input.get("productName"));

		Assert.assertTrue(matchValue);

		CheckOutPageNew checkoutpagenew = cartpage.clickCheckOutButton();

		checkoutpagenew.countryClick("India");
		ConfirmationPageNeww confirmationpagenew = checkoutpagenew.submitOrder();

		String finalMessage = confirmationpagenew.getConfirmationMsg();

		Assert.assertTrue(finalMessage.equalsIgnoreCase("Thankyou for the order."));

		System.out.println("Positive flow End to End" + " " + input.get("productName"));

		//testingCICD

	}

	@Test(dependsOnMethods = { "submitOrder" })
	public void OrderTest() {

		ProductCatalogueNew productCat = landingpage.loginApplication("hemanthm797@gmail.com", "Hemanth12*");
		OrderPageNeww orderpagenew = productCat.goToOrderPage();
		boolean orderPageValue = orderpagenew.toVerifyTheOrderPage(productName);
		Assert.assertTrue(orderPageValue);

		System.out.println("Order Page - Product Verification");

	}

	@DataProvider
	public Object[][] getDataNewww() throws IOException {

		
/*	  HashMap<String, String> map = new HashMap<String, String>(); map.put("email",
		  "hemanthm797@gmail.com"); map.put("password", "Hemanth12*");
		  map.put("productName", "IPHONE 13 PRO");
		  
		  HashMap<String, String> map1 = new HashMap<String, String>();
		  map1.put("email", "hemanthm797@gmail.com"); map1.put("password",
		 "Hemanth12*"); map1.put("productName", "ZARA COAT 3");
		return new Object[][] { { map}, { map1 }}; */
		 

		List<HashMap<String, String>> data = getJSONdataToMap(
				System.getProperty("user.dir") + "//src//test//java/Hemanth//dataNew//PurchaseOrderNew.json");

		//C:\Users\Hemanth Mohan\eclipse-workspace-new\SeleniumFrameworkDesignng\src\test\java\Hemanth\dataNew\PurchaseOrderNew.json
		return new Object[][] {{ data.get(0) }, {data.get(1)}};
	}

}
