package Demo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class LoginUsingXML {

	@Test
	public void login() throws SAXException, IOException, ParserConfigurationException {

		Document file = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new File("./src/main/resources/demo.objectrepository/LoginPage.xml"));

		// fetching the string value
		String user = file.getElementsByTagName("usernamefield").item(0).getTextContent();
		String pwd = file.getElementsByTagName("passwordfield").item(0).getTextContent();
		String btn = file.getElementsByTagName("loginbtnfield").item(0).getTextContent();

		// splitting and storing separately
		String userLoc = user.split(":")[0];
		String userLocValue = user.split(":")[1];

		String pwdLoc = pwd.split(":")[0];
		String pwdLocValue = pwd.split(":")[1];

		String btnLoc = btn.split(":")[0];
		String btnLocValue = btn.split(":")[1];

		// launch browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/");

		// Username
		if (userLoc.equals("name"))
			driver.findElement(By.name(userLocValue)).sendKeys("Admin");

		// Password
		if (pwdLoc.equals("name"))
			driver.findElement(By.name(pwdLocValue)).sendKeys("admin123");

		// Login Button
		if (btnLoc.equals("cssSelector"))
			driver.findElement(By.cssSelector(btnLocValue)).click();
	}
}