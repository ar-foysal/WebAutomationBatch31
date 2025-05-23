package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class HandleWebAlert extends DriverSetup{

    @Test
    public void interactWithAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();
        System.out.println(alertText);
        alert.accept();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Thread.sleep(2000);
        alertText = alert.getText();
        System.out.println(alertText);

        alert.dismiss();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        Thread.sleep(2000);
        alertText = alert.getText();
        System.out.println(alertText);

        alert.sendKeys("Hello");
        Thread.sleep(2000);

        alert.accept();
        Thread.sleep(2000);
    }
}
