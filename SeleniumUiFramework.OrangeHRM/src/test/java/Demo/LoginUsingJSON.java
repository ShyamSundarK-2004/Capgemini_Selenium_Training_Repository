package Demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginUsingJSON {

	@Test
	public void login() throws IOException {

		// Read JSON file
		String data = new String(
				Files.readAllBytes(Paths.get("./src/main/resources/demo.objectrepository/Loginpage.json")));
		JSONObject obj = new JSONObject(data);
		JSONObject loginPage = obj.getJSONObject("login");

		// extracting the data and spliting the data
		String[] username = loginPage.getString("user").split(":");
		String[] password = loginPage.getString("pwd").split(":");
		String[] loginbtn = loginPage.getString("loginbtn").split(":");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/");

		// Fetch locators from JSON
		if (username[0].equals("name"))
			driver.findElement(By.name(username[1])).sendKeys("Admin");
		if (password[0].equals("name"))
			driver.findElement(By.name(password[1])).sendKeys("admin123");
		if (loginbtn[0].equals("cssSelector"))
			driver.findElement(By.cssSelector(loginbtn[1])).click();

//		LoginPage login = new LoginPage(driver);
//		login.setUsername(username[1]);
//		login.setPassword(password[1]);
	}
}