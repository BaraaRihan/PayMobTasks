package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WithoutTestNg {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://magento.softwaretestingboard.com/");

// Click on "Create an Account" link
        driver.findElement(By.linkText("Create an Account")).click();

// Fill in account creation form
        driver.findElement(By.id("firstname")).sendKeys("BOB");
        driver.findElement(By.id("lastname")).sendKeys("Mark");
        driver.findElement(By.name("email")).sendKeys("Bob.Ma4rk@gmail.com");
        driver.findElement(By.cssSelector("[title='Password']")).sendKeys("Password@1234");
        driver.findElement(By.name("password_confirmation")).sendKeys("Password@1234");

// Click on "Create" button
        driver.findElement(By.className("primary")).click();

// Navigate back to homepage
        driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/a")).click();

// Move to the first product and click "Add to Compare"
        WebElement firstProduct = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[3]/div[3]/div/div/ol/li[4]/div"));
        Actions actions = new Actions(driver);
        actions.moveToElement(firstProduct).perform();
        driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[3]/div[3]/div/div/ol/li[4]/div/div/div[3]/div/div[2]/a[2]")).click();

// Move to the second product and click "Add to Compare"
        WebElement secondProduct = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[3]/div[3]/div/div/ol/li[5]/div/a/span/span/img"));
        actions.moveToElement(secondProduct).perform();
        driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[3]/div[3]/div/div/ol/li[5]/div/div/div[3]/div/div[2]/a[2]")).click();
    }

}
