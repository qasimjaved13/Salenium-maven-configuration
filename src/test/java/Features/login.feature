Feature: LoginFeature
  This feature deals with login functionality

  Scenario: Login with correct username and password
    Given I navigate to login page
    And I enter the following details for login
      | username | asad.zia@siparadigm.com |
      | password | welcome123              |
    And i click on login button
    Then i should see the dashboard page


