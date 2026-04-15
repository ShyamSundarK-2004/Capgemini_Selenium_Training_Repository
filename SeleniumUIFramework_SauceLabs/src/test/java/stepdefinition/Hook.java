package stepdefinition;

import java.io.IOException;

import org.openqa.selenium.edge.EdgeDriver;

import com.seleniumuiframework.saucelabs.utilities.AllUtilityFunctions;
import com.seleniumuiframework.saucelabs.utilities.BaseClass;
import com.seleniumuiframework.saucelabs.utilities.Pages;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends AllUtilityFunctions {

	// call the driver from the Baseclass and it handles the pre and the post
	// conditions
	private BaseClass b;

	public Hook(BaseClass b) {
		this.b = b;

	}

	// this process is called as dependncy injection
	@Before
	public void setup() throws IOException {
		// reading from property file
		String url = getPropertyKeyValue("url");
		String userName = getPropertyKeyValue("username");
		String password = getPropertyKeyValue("password");

		// browser setup and launching
		b.driver = new EdgeDriver();
		driver = b.driver;
		configMaximizeBrowser();
		waitForElements(10);

		// navigate to url
		enterURL(url);

		// intialize the pages
		Pages.loadAllPages(b.driver);

		// login
		Pages.loginPage.login(userName, password);

	}

	@After
	public void testLogoff() {
		Pages.inventoryPage.logout();
		quitBroswerWindow();
	}

}
