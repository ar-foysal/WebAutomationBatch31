package org.example;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class HandleBrowserRelatedTask extends DriverSetup{

    @Test
    public void testBrowserTask() throws InterruptedException {
        driver.get("https://www.google.com");

        String title = driver.getTitle();
        System.out.println("Title: " + title);

        String url = driver.getCurrentUrl();

        System.out.println("URL: "+ url);
        Thread.sleep(1000);

        driver.manage().window().fullscreen();
        Thread.sleep(1000);

        driver.manage().window().minimize();
        Thread.sleep(1000);

        driver.manage().window().maximize();
        Thread.sleep(1000);


        driver.navigate().to("https://www.facebook.com");
        Thread.sleep(1000);

        driver.navigate().back();
        Thread.sleep(1000);

        driver.navigate().forward();
        Thread.sleep(1000);

        driver.navigate().refresh();
        Thread.sleep(1000);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.whatsapp.com");

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.instagram.com");
        Thread.sleep(3000);


       String tabHandle = driver.getWindowHandle();
       System.out.println("Insta: " + tabHandle);

       List<String> handles = new ArrayList<>( driver.getWindowHandles());

       for (String handle: handles){
           System.out.println(handle);
       }

       System.out.println("Before Switching: " + driver.getCurrentUrl());

       driver.switchTo().window(handles.get(0));

       System.out.println("After Switching: " + driver.getCurrentUrl());


       driver.close();
       Thread.sleep(3000);

//       driver.quit();






    }
}
