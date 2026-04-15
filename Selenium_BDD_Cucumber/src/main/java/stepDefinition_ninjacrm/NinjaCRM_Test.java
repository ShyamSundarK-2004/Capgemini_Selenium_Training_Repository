package stepDefinition_ninjacrm;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NinjaCRM_Test {

	WebDriver driver;

	@Given("launching the browser")
	public void launching_the_browser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Given("Navigate to ninja crm")
	public void navigate_to_ninja_crm() {
		driver.get("http://49.249.28.218:8098/");
	}

	@When("enter the username and password")
	public void enter_the_username_and_password() {
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("password")).sendKeys("rmgy@9999");

	}

	@When("click on login button")
	public void click_on_login_button() {
		driver.findElement(By.cssSelector("[type='submit']")).click();
	}

	@When("click on campaign module")
	public void click_on_campaign_module() {
		driver.findElement(By.linkText("Campaigns")).click();
	}

	@When("click on create campaign button in campaignpage")
	public void click_on_create_campaign_button_in_campaignpage() {
		driver.findElement(By.xpath("//span[text()= 'Create Campaign']")).click();
	}

	@When("enter the campaign name")
	public void enter_the_campaign_name() {
		driver.findElement(By.name("campaignName")).sendKeys("Capgemini");
	}

	@When("enter the target size")
	public void enter_the_target_size() {
		driver.findElement(By.name("targetSize")).sendKeys("10");
	}

	@When("click on create campaign button")
	public void click_on_create_campaign_Button() {
		driver.findElement(By.cssSelector("[type='submit']")).click();
	}

	@Then("verify the popup alert")
	public void verify_the_popup_alert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement alert = driver.findElement(By.cssSelector("[role='alert']"));
		wait.until(ExpectedConditions.visibilityOf(alert));
		String msg = alert.getText();
		System.out.println(msg.contains("Successfully") ? "verified" : "Not verified");
	}

	@Then("logout from the application")
	public void logout_from_the_application() {
		driver.findElement(By.cssSelector("[class='user-icon']")).click();
		driver.findElement(By.xpath("//div[text() = 'Logout ']")).click();
	}

}
