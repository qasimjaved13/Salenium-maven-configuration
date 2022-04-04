Feature: LoginFeature
  This feature deals with login functionality

  Scenario: Login with correct username and password
    Given I navigate to login page
    And I enter the following details for login
      | username | admin    |
      | password | admin123 |
    And i click on login button
    Then i should see the dashboard page


  Scenario: Login with invalid username and password
    Given I navigate to login page
    And I enter the following invalid details for login
      | username | admin |
      | password | admin |
    And i click on login button
    Then I should not see the dashboard page