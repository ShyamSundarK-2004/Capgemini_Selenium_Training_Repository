package com.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.in/");

        Thread.sleep(3000);

        // Locate search box
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        searchBox.sendKeys("iPhone 15");
        searchBox.sendKeys(Keys.ENTER);

        Thread.sleep(4000);

        // Get first product title
        WebElement firstProduct = driver.findElement(
                By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
        );

        System.out.println("First Product: " + firstProduct.getText());

        driver.quit();
    }
}