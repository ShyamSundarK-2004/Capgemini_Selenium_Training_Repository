package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCart_Test {

	WebDriver driver;

	@Given("launch the browser")
	public void launch_the_browser() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Given("navigate to the application by url {string}")
	public void navigate_to_the_application_by_url(String Url) {
		driver.get(Url);
	}

	@When("enter username {string} and password {string}")
	public void enter_username_and_password(String userName, String password) {
		driver.findElement(By.id("user-name")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("click on login button in login page")
	public void click_on_login_button_in_login_page() {
		driver.findElement(By.id("login-button")).click();
	}

	@When("inventory is displayed click on product {string}")
	public void inventory_is_displayed_click_on_product(String productName) {
		driver.findElement(By.xpath("//div[text() = '" + productName + "']")).click();
	}

	@When("click on add to cart button")
	public void click_on_add_to_cart_button() {
		driver.findElement(By.id("add-to-cart")).click();
	}

	@When("product added to cart click on cart button")
	public void product_added_to_cart_click_on_cart_button() {
		driver.findElement(By.id("shopping_cart_container")).click();
	}

	@Then("validate the product name {string}")
	public void validate_the_product_name(String productName) {
		String text = driver.findElement(By.className("inventory_item_name")).getText();
		Assert.assertEquals(productName, text);
	}

	@When("click on menu button")
	public void click_on_menu_button() {
		driver.findElement(By.id("react-burger-menu-btn")).click();
	}

	@When("click on logout")
	public void click_on_logout() {
		driver.findElement(By.linkText("Logout")).click();
	}

}
