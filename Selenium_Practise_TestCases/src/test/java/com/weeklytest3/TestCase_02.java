package com.weeklytest3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestCase_02 {

	WebDriver driver = null;
	WebDriverWait wait = null;

	@Test
	public void launchingbrowser() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	@Test(dependsOnMethods = "launchingbrowser")
	public void login() {
		// Login with valid credentials
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		// verification
		WebElement swagLabsText = driver.findElement(By.xpath("//div[text()='Swag Labs']"));
		Assert.assertTrue(swagLabsText.getText().contains("Swag Labs"), "Login Not Displayed");
	}

	@Test(dependsOnMethods = "login")
	public void filterOption() {
		// clicking on dropdown
		WebElement dropdown = driver.findElement(By.className("product_sort_container"));

		// clicking low to high price
		Select s = new Select(dropdown);
		s.selectByIndex(2);

		// clicking on add to cart on product 1
		driver.findElement(By.name("add-to-cart-sauce-labs-onesie")).click();
		// clicking on add to cart on product 2
		driver.findElement(By.name("add-to-cart-sauce-labs-bike-light")).click();
		// clicking on add to cart on product 3
		driver.findElement(By.name("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		// navigating to cart
		driver.findElement(By.className("shopping_cart_link")).click();
		// getting cart content
		String cartText = driver.findElement(By.className("cart_list")).getText();
		// validating cart products
		Assert.assertTrue(cartText.contains("Sauce Labs Onesie") && cartText.contains("Sauce Labs Bike Light")
				&& cartText.contains("Sauce Labs Bolt T-Shirt"), "Cart Validation Failed");
		Reporter.log("Cart Validation Successfull", true);
		// clicking checkout
		driver.findElement(By.id("checkout")).click();
		// first name
		driver.findElement(By.id("first-name")).sendKeys("Shyam");
		// second name
		driver.findElement(By.id("last-name")).sendKeys("Sundar K");
		// postal code
		driver.findElement(By.id("postal-code")).sendKeys("600099");
		// click on continue
		driver.findElement(By.id("continue")).click();
		// validating order summary
		String orders = driver.findElement(By.className("cart_list")).getText();
		Assert.assertTrue(orders.contains("Sauce Labs Onesie") && orders.contains("Sauce Labs Bike Light")
				&& orders.contains("Sauce Labs Bolt T-Shirt"), "orders Listed Wrong");
		Reporter.log("Orders Validation Successfull", true);
		// clicking finish
		driver.findElement(By.id("finish")).click();
		// validating orders placed or not
		// checking title
		String status = driver.findElement(By.className("title")).getText();
		// checking for order completed image
		Assert.assertTrue(status.contains("Complete") && driver.findElement(By.className("pony_express")).isDisplayed(),
				"Order Not Placed");
		Reporter.log("Orders Placed Successfully", true);
	}

	@Test(dependsOnMethods = "login")
	public void logout() {

		// logout
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
		driver.quit();
	}

}
