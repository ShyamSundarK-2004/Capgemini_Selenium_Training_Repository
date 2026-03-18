package Demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginUsingJSON {

	@Test
	public void login() throws IOException {
		FileInputStream fs = new FileInputStream("./src/main/resources/demo.objectrepository/Loginpage.json");

		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(fs);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.findElement(By.name(node.get("user").asText().split(":")[1])).sendKeys("Admin");
		driver.findElement(By.name(node.get("pwd").asText().split(":")[1])).sendKeys("admin123");
		driver.findElement(By.cssSelector(node.get("loginbtn").asText().split(":")[1])).click();

	}

}
