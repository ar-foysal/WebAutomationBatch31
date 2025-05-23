package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HandleIFrameElement extends DriverSetup{

    @Test
    public void interactWithFrameElement() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");


//        driver.switchTo().frame("courses-iframe");
//        driver.switchTo().frame("iframe-name");
        driver.switchTo().frame(0);
//        WebElement iframe = driver.findElement(By.id("courses-iframe"));
//        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//a[normalize-space()='Register']"));

        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//legend[normalize-space()='iFrame Example']"));


    }
}
