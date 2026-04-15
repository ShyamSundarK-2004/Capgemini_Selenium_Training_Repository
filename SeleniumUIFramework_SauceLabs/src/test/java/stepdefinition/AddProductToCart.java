package stepdefinition;

import org.testng.Assert;

import com.seleniumuiframework.saucelabs.utilities.BaseClass;
import com.seleniumuiframework.saucelabs.utilities.Pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddProductToCart {

	private BaseClass b;

	public AddProductToCart(BaseClass b) {
		this.b = b;
	}

	@When("inventory is displayed click on product {string}")
	public void inventory_is_displayed_click_on_product(String productName) {
		Pages.inventoryPage.clickOnProduct(b.driver, productName);
	}

	@When("click on add to cart button")
	public void click_on_add_to_cart_button() {
		Pages.inventoryItemPage.clickOnAddToCart();
	}

	@When("product added to cart click on cart button")
	public void product_added_to_cart_click_on_cart_button() {
		Pages.inventoryPage.clickOnCartBtn();
	}

	@Then("validate the product name {string}")
	public void validate_the_product_name(String productName) {
		String text = Pages.cartPage.captureProductName();
		Assert.assertEquals(productName, text);
	}

}
