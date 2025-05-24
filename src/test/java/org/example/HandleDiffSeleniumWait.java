package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class HandleDiffSeleniumWait extends DriverSetup{
    @Test
    public void testDelayElement() throws InterruptedException {
        driver.get("https://qavbox.github.io/demo/delay/");

        driver.findElement(By.xpath("//input[@name='commit1']")).click();
//        Thread.sleep(10000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement h2 = driver.findElement(By.xpath("//div[@id='oneMore']//h2"));
        System.out.println(h2.getText());
        driver.findElement(By.xpath("//input[@id='loaderStart']")).click();
        h2 = driver.findElement(By.xpath("//h2[@id='loaderdelay']"));
        System.out.println(h2.getText());

        driver.findElement(By.xpath("//input[@name='commit']")).click();

//        h2 = driver.findElement(By.xpath("//h2[@id='two']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.textToBePresentInElement(h2, "I am here!"));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h2[@id='two']"), "I am here!"));
        System.out.println("Text: " + driver.findElement(By.xpath("//h2[@id='two']")).getText());

    }
}
