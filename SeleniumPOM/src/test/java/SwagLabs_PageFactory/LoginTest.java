package SwagLabs_PageFactory;

import org.testng.annotations.Test;

import objectRepository.BaseClass;
import objectRepository_PageFactory.LoginPage_PageFactory;

public class LoginTest extends BaseClass {
	@Test
	public void login() {
		LoginPage_PageFactory lg = new LoginPage_PageFactory(driver);
		lg.webpage_url("https://www.saucedemo.com/");
		lg.enterCredentials("standard_user", "secret_sauce");
		lg.clickLogin();

	}
}
