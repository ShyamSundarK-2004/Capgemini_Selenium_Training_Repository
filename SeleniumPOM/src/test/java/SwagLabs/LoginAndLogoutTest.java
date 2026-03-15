package SwagLabs;

import org.testng.annotations.Test;

import objectRepository.BaseClass;
import objectRepository.LoginPage;
import objectRepository.LogoutPage;

public class LoginAndLogoutTest extends BaseClass {

	@Test(priority = 1)
	public void login() {
		LoginPage lg = new LoginPage(driver);
		lg.enterCredentials("standard_user", "secret_sauce");
		lg.clickLogin();

	}

	@Test(priority = 2, dependsOnMethods = "login")
	public void Logout() {
		LogoutPage lt = new LogoutPage(driver);
		lt.clickMenu();
		lt.clickLogout();
	}
}
