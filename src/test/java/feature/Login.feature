Feature: Login feature
  Background:
    Given User should be on the login page


  Scenario: User should be able to login with valid credentials
    When User enter valid username
    And User enter valid password
    And User click on the Login button
    Then User should successfully logged in
    But  User should not see the login button

  Scenario: User should not be able to login with invalid password
    When User enter valid username
    And User enter invalid "Hello" password
    And User click on the Login button
    Then User should see the error msg "Incorrect username or password entered. Please try again."
    But  User should see the login button


  Scenario Outline: User should not be able to login with invalid credentials
    When User enter <username> on the username input box
    And User enter <password> on the password input box
    And User click on the Login button
    Then User should see the error msg "Incorrect username or password entered. Please try again."
    But  User should see the login button
    Examples:
      | username       | password |
      | ""             | ""       |
      |"Automation1230"| ""       |
