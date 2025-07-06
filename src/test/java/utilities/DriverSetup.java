package utilities;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class DriverSetup {

    private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    public static  void setDriver(WebDriver driver){
        DriverSetup.DRIVER_THREAD_LOCAL.set(driver);
    }

    public static WebDriver getDriver(){
        return DRIVER_THREAD_LOCAL.get();
    }

    public static void startBrowser(String browser_name){
        WebDriver driver = getBrowser(browser_name);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        setDriver(driver);
    }

    public static void closeBrowser(Scenario scenario){
        takeSSOnFailedCase(scenario);
        getDriver().quit();
    }


    public static WebDriver getBrowser(String name){
        if (name.equalsIgnoreCase("Edge"))
            return new EdgeDriver();
        else if (name.equalsIgnoreCase("chrome"))
            return new ChromeDriver();
        else if (name.equalsIgnoreCase("firefox"))
            return new FirefoxDriver();
        else {
            throw new RuntimeException("Browser is not available with the given name: " + name);
        }
    }

    public static void takeSSOnFailedCase(Scenario scenario){
        if (scenario.isFailed()){
            String name = scenario.getName().replaceAll(" ", "_");
            byte[] source = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(source, "image/png", name);
        }

    }
}
