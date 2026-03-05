package com.webDriverInterrogationMethods;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Verification_WindowHandles {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.navigate().to("https://demoapps.qspiders.com/ui/browser?sublist=0");
		Thread.sleep(2000);

		// fetching the session ID using getwindowhandles return single session ID
		String ParentsesID = driver.getWindowHandle();
		System.out.println(ParentsesID);
		driver.findElement(By.xpath("//h2[.='Watches']/following-sibling::button")).click();

		// fetching the session ids of multiple windows
		Set<String> sessionIDs = driver.getWindowHandles();
		sessionIDs.remove(ParentsesID);
		System.out.println(sessionIDs);

		// to remove or iterate the session IDs of the window
		// we can use iterator() and for each also
		Iterator<String> i = sessionIDs.iterator();
		while (i.hasNext())
			if (i.equals(ParentsesID)) {
				i.remove();
				break;
			}
	}

}
