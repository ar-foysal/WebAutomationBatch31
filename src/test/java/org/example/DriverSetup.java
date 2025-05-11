package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DriverSetup {
    public WebDriver driver;

    @BeforeSuite
    public void startBrowser(){
        driver =  new EdgeDriver();
    }

    @AfterSuite
    public void closeBrowser(){
        driver.quit();
    }
}
