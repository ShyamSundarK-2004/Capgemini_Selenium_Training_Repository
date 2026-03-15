package SwagLabs;

import org.testng.annotations.Test;

import objectRepository.BaseClass;
import objectRepository.LoginPage;

public class LoginTest extends BaseClass {
	@Test
	public void login() {
		LoginPage lg = new LoginPage(driver);
		lg.webpage_url("https://www.saucedemo.com/");
		lg.enterCredentials("standard_user", "secret_sauce");
		lg.clickLogin();

	}

}
