package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {

	WebDriver driver;

	@Given("open the browser")
	public void open_the_browser() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Given("Navigate to Application")
	public void navigate_to_application() {
		driver.get("https://www.saucedemo.com/");
	}

	@When("enter username and password")
	public void enter_username_and_password() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
	}

	@When("click on login button")
	public void click_on_login_button() {
		driver.findElement(By.id("login-button")).click();
	}

	@Then("verify Homepage")
	public void verify_homepage() {
		System.out.println(driver.findElement(By.className("app_logo")).isDisplayed() == true ? "home page verified"
				: "home page not displayed");
	}

}
