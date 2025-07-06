package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static utilities.DriverSetup.closeBrowser;
import static utilities.DriverSetup.startBrowser;

public class Hooks {
    private static String browser_name = System.getProperty("browser", "Chrome");

    @Before
    public  void startDriver(){
        startBrowser(browser_name);
    }

    @After
    public void  closeDriver(Scenario scenario){
        closeBrowser(scenario);
    }

}
