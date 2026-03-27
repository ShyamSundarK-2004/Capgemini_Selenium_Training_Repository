package Demo;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginUsingProperties {

	@Test
	public void loginTest() throws Exception {

		// 🔥 Load properties file
		FileInputStream fis = new FileInputStream("./data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.name(prop.getProperty("user").split(":")[1])).sendKeys("Admin");
		driver.findElement(By.name(prop.getProperty("pwd").split(":")[1])).sendKeys("admin123");
		driver.findElement(By.cssSelector(prop.getProperty("loginbtn").split(":")[1])).click();

	}
}