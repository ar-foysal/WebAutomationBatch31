package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class InteractingWithWebElement extends DriverSetup{
    @Test
    public void interactWithElement() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement head = driver.findElement(By.xpath("//h1[normalize-space()='Practice Page']"));

        String headText = head.getText();
        System.out.println(headText);

        WebElement radioBtn2 = driver.findElement(By.cssSelector("input[value='radio2']"));
        radioBtn2.click();

        WebElement name = driver.findElement(By.cssSelector("#name"));
        name.sendKeys("Batch 31");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#name")).clear();
        Thread.sleep(3000);
        String placeholder_text =  name.getAttribute("placeholder");
        System.out.println(placeholder_text);

        WebElement openTab = driver.findElement(By.cssSelector("#opentab"));
        String color =  openTab.getCssValue("background-color");
        System.out.println(color);

        WebElement radioBtn1 = driver.findElement(By.cssSelector("input[value='radio1']"));
        System.out.println("Btn1: " + radioBtn1.isSelected());
        System.out.println("Btn2: " + radioBtn2.isSelected());

        WebElement show_hide_box = driver.findElement(By.xpath("//input[@id='displayed-text']"));

        System.out.println(show_hide_box.isDisplayed());

        driver.findElement(By.cssSelector("#hide-textbox")).click();
        System.out.println(show_hide_box.isDisplayed());

        System.out.println("checkbox state:" + driver.findElement(By.id("checkBoxOption1")).isEnabled());
    }
}
