Feature: Signup
  This feature UI tests the signup page where a user can fill in their basic details to create a new account.

  Background:
    Given Driver set up for signup page

  Scenario: Navigation to signup page
    Given I am currently on the home page
    When I press the signup button
    Then I should see the signup page

  Scenario Outline: Incorrect signup
    Given I visit the signup page
    When I enter <username> as new account user name field
    And I enter <password> as new account password field
    And I enter <retypedPassword> as new account retyped password field
    And I tick <termsAccepted> for terms and conditions
    And I press the signup submit button
    Then I should see the invalid credentials message
    Examples:
      | username | password      | termsAccepted | retypedPassword |
      | ""       | "Password123" | "true"        | "Password123"   |
      | "user1"  | "Password123" | "false"       | "Password123"   |
      | "user2"  | "Password"    | "false"       | "Password"      |
      | "user2"  | "password123" | "false"       | "password123"   |
      | "user2"  | "Pass1"       | "false"       | "Pass1"         |
      | "user2"  | "Password123" | "false"       | "password"      |
      | "user2"  | "Password123" | "false"       | "Password123"   |

  Scenario: Correct signup
    Given I visit the signup page
    When I enter "user2" as new account user name field
    And I enter "Password123" as new account password field
    And I enter "Password123" as new account retyped password field
    And I tick "true" for terms and conditions
    And I press the signup submit button
    Then I should see the welcome page for the created account