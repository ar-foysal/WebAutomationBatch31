package step_definitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LoginPage;
import pages.MainPage;

public class Login {
    MainPage mainPage = new MainPage();
    LoginPage loginPage = new LoginPage();

    @Given("User should be on the login page")
    public void userShouldBeOnTheLoginPage() {
        mainPage.loadAPage(mainPage.url);
        mainPage.clickOnElement(mainPage.login_btn);
    }

    @When("User enter valid username")
    public void userEnterValidUsername() {
        loginPage.writeOneElement(loginPage.username_input, loginPage.username);
    }

    @And("User enter valid password")
    public void userEnterValidPassword() {
        loginPage.writeOneElement(loginPage.password_input, loginPage.password);
    }

    @And("User click on the Login button")
    public void userClickOnTheLoginButton() {
        loginPage.clickOnElement(loginPage.login_btn);
    }

    @Then("User should successfully logged in")
    public void userShouldSuccessfullyLoggedIn() {
        Assert.assertEquals(mainPage.getElementText(mainPage.username), loginPage.username);

    }

    @But("User should not see the login button")
    public void userShouldNotSeeTheLoginButton() {
        Assert.assertTrue(mainPage.waitForElementVisible(mainPage.user_icon).isDisplayed());
    }

    @And("User enter invalid {string} password")
    public void userEnterInvalidPassword(String password) {
        loginPage.writeOneElement(loginPage.password_input, password);

    }


    @But("User should see the login button")
    public void userShouldSeeTheLoginButton() {
        Assert.assertTrue(mainPage.waitForElementVisible(loginPage.login_btn).isDisplayed());

    }

    @Then("User should see the error msg {string}")
    public void userShouldSeeTheErrorMsg(String arg0) {
        Assert.assertEquals(loginPage.getElementText(loginPage.error_message), arg0);
    }

    @When("User enter {string} on the username input box")
    public void userEnterUsernameOnTheUsernameInputBox(String username) {
        loginPage.writeOneElement(loginPage.username_input, username);

    }

    @And("User enter {string} on the password input box")
    public void userEnterPasswordOnThePasswordInputBox(String password) {
        loginPage.writeOneElement(loginPage.password_input, password);

    }
}
