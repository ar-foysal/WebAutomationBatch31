package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HandleDifferentActions extends DriverSetup{

    @Test
    public void testActions() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Actions actions = new Actions(driver);

        actions.scrollByAmount(0, 1000).build().perform();

//        WebElement el = driver.findElement(By.xpath("//legend[normalize-space()='Mouse Hover Example']"));

//        actions.scrollToElement(el).build().perform();
        actions.moveToElement(driver.findElement(By.xpath("//button[@id='mousehover']"))).build().perform();

        actions.scrollToElement(driver.findElement(By.xpath("//legend[normalize-space()='Suggession Class Example']"))).build().perform();

        WebElement el = driver.findElement(By.xpath("//input[@id='autocomplete']"));
        el.sendKeys("Bangladesh");
        Thread.sleep(3000);

        actions.keyDown(Keys.CONTROL).sendKeys("a").build().perform();
        Thread.sleep(3000);
        actions.keyDown(Keys.CONTROL).sendKeys("x").build().perform();
        Thread.sleep(3000);

        el = driver.findElement(By.xpath("//input[@id='name']"));

        actions.click(el).keyDown(Keys.CONTROL).sendKeys("v").build().perform();

        Thread.sleep(3000);

    }
}
