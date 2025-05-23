package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class HandleDropdownWithSelect extends DriverSetup{

    @Test
    public void interactWithDropdown() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement selectElement = driver.findElement(By.id("dropdown-class-example"));
        Select select = new Select(selectElement);

        selectElement.click();

        select.selectByIndex(2);
        Thread.sleep(2000);
        select.selectByVisibleText("Option3");

        Thread.sleep(2000);

        select.selectByValue("option1");
        Thread.sleep(2000);

        WebElement selected_option = select.getFirstSelectedOption();
        System.out.println(selected_option.getText());

        List<WebElement> all_options =  select.getOptions();
        System.out.println(all_options.size());
        for (WebElement option: all_options ){
            System.out.println(option.getText());
        }

    }
}
