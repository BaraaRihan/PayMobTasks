package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Bonus {

        WebDriver driver;
        @BeforeClass
        public void setUp() {
            // Set up WebDriver
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            // Navigate to the  website
            driver.get("https://magento.softwaretestingboard.com/");


        }

        @Test(priority = 1)
        public void createAccount() {
            // Click on "Create an Account" link
            driver.findElement(By.linkText("Create an Account")).click();
            // Fill in account creation form
            driver.findElement(By.id("firstname")).sendKeys("BOB");
            driver.findElement(By.id("lastname")).sendKeys("Mark");
            driver.findElement(By.name("email")).sendKeys("Bob.Ma0124rk@gmail.com");
            driver.findElement(By.cssSelector("[title='Password']")).sendKeys("Password@1234");
            driver.findElement(By.name("password_confirmation")).sendKeys("Password@1234");
            // Click on "Create" button
            driver.findElement(By.className("primary")).click();

        }

        @Test(priority = 2)
        public void addProductsToCompare() {

// Move to the First product and click "Add to Compare"
            WebElement firstProduct = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[3]/div[3]/div/div/ol/li[4]/div"));
            Actions actions = new Actions(driver);
            actions.moveToElement(firstProduct).perform();
            WebElement Compare1 = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[3]/div[3]/div/div/ol/li[4]/div/div/div[3]/div/div[2]/a[2]"));
            Compare1.click();

// Move to the second product and click "Add to Compare"
            WebElement secondProduct = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[3]/div[3]/div/div/ol/li[5]/div/a/span/span/img"));
            actions.moveToElement(secondProduct).perform();
            driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[3]/div[3]/div/div/ol/li[5]/div/div/div[3]/div/div[2]/a[2]")).click();
        }

      /*  @AfterClass
        public void tearDown() {
            
            driver.quit();
        }*/
    }


