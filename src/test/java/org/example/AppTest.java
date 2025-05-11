package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class AppTest extends DriverSetup{

    @Test
    public void testWebPageLoad() {
       driver.get("https://google.com");
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void testWebPageTitle() {
        driver.get("https://google.com");
        System.out.println(driver.getTitle());
    }


}
