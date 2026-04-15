package stepDefinition;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Flipkart_addToCart_Test {

	WebDriver driver;

	@Given("launching the browser")
	public void launching_the_browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Given("go to the application by url {string}")
	public void go_to_the_application_by_url(String Url) {
		driver.get(Url);
	}

	@When("popup comes click on cancel button")
	public void popup_comes_click_on_cancel_button() {
		driver.findElement(By.xpath("//span[text()='✕']")).click();
	}

	@When("search the product {string}")
	public void search_the_product(String productName) {
		driver.findElement(By.name("q")).sendKeys(productName, Keys.ENTER);
	}

	@When("click on product {string}")
	public void click_on_product(String productName) {
		driver.findElement(By.xpath("//div[text()='" + productName + "']")).click();
	}

	@When("navigate to the new window")
	public void navigate_to_the_new_window() {
		String parent = driver.getWindowHandle();
		Set<String> list = driver.getWindowHandles();
		list.remove(parent);
		Iterator<String> i = list.iterator();
		while (i.hasNext()) {
			driver.switchTo().window(i.next());
		}

	}

	@When("read the product price and print the product price")
	public void read_the_product_price_and_print_the_product_price() {
		String price = driver.findElement(By.xpath("//div[@class = 'v1zwn21k v1zwn20 _1psv1zeb9 _1psv1ze0']"))
				.getText();
		System.out.println(price);
	}

	@When("click on add to cart icon")
	public void click_on_add_to_cart_icon() {
		driver.findElement(By.xpath("//div[@style='transform: translateY(0px) scale(1);']")).click();
	}

	@When("navigate to cart")
	public void navigate_to_cart() {
		driver.findElement(By.xpath("//span[@class=\"v1zwn27\" and text()='Cart' ]")).click();
	}

	@Then("verify the product name {string}")
	public void verify_the_product_name(String productName) {
		String text = driver.findElement(By.xpath("//div[@style='width: 551.111px;']")).getText();
		Assert.assertTrue(text.contains(productName));
	}

}
