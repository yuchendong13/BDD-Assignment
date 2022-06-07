Feature: Manage Account
  This feature UI tests the manage account details page where a user can change their username, password, shipping
  details and their payment details.

  Background:
    Given Driver set up for manage account page
    And User is logged in

  Scenario: Navigation to manage-account page
    Given I start on the home page
    When I press the manage account button
    Then I should see the manage account page

  Scenario Outline: Change username unsuccessfully
    Given I am currently on the manage account page
    When I enter <username> in the new username field
    And I press the submit username button
    Then I should see the invalid username message

    Examples:
      | username |
      | ""       |
      | "user1"  |

  Scenario: Change username successfully
    Given I am currently on the manage account page
    When I enter "user3" in the new username field
    And I press the submit username button
    Then I should see the new current username

  Scenario Outline: Change password unsuccessfully
    Given I am currently on the manage account page
    When I enter <currentPassword> as current password field
    And I enter <password> as new password field
    And I enter <retypedPassword> as retyped new password field
    And I press the submit password button
    Then I should see the invalid password message

    Examples:
      | currentPassword    | password    | retypedPassword |
      | "wrongOldPassword" | "Pa55word"  | "Pa55word"      |
      | "Password123"      | "Password"  | "Password"      |
      | "Password123"      | "password6" | "password6"     |
      | "Password123"      | "Pass1"     | "Pass1"         |
      | "Password123"      | "Pa55word"  | "Password"      |

    Scenario: Change password successfully
      Given I am currently on the manage account page
      When I enter "Password123" as current password field
      And I enter "Pa55word" as new password field
      And I enter "Pa55word" as retyped new password field
      And I press the submit password button
      Then I should see the password changed message

  Scenario: Change shipping address
    Given I am currently on the manage account page
    When I enter "8, Rollers Avenue, Paper town" in shipping address field
    And I press the submit shipping details button
    Then I should see the new address as my shipping address

  Scenario: Change shipping preferences
    Given I am currently on the manage account page
    When I enter "Only available on weekends" in shipping preference field
    And I press the submit shipping details button
    Then I should see the new preference as my shipping preference

  Scenario: Delete shipping details
    Given I am currently on the manage account page
    When I press delete button in the shipping details section
    Then Shipping details should be cleared in the page

  Scenario: Change payment details - unsuccessfully
    Given I am currently on the manage account page
    When I enter "0123456789" in the card number field
    And I enter "Carlos Vela" in the card holder field
    And I enter "420" in the cvv field
    And I enter "12320" in the expiry year field
    And I press the submit payment details button
    Then I should see invalid payment credentials

  Scenario: Change payment details - successfully
    Given I am currently on the manage account page
    When I enter "0123456789111111" in the card number field
    And I enter "Antonio Cruise" in the card holder field
    And I enter "120" in the cvv field
    And I enter "10/26" in the expiry year field
    And I press the submit payment details button
    Then I should see new payment credentials

  Scenario: Delete payment details
    Given I am currently on the manage account page
    When I press the delete button in the payment details section
    Then Payment details should be cleared in the page