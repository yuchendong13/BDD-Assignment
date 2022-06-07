Feature: ManageExistingArt

  Background:
    Given Driver set up for remove art page

  Scenario: Remove existing artwork
    Given I am on the remove art page
    When I enter "1" as remove id field
    And I click on the Submit Id to Remove button
    Then I should see art successfully remove message

  Scenario Outline: Remove invalid id
    Given I am on the remove art page
    When I enter <id> as remove id field
    And I click on the Submit Id to Remove button
    Then I should see remove art error
    Examples:
      | id    |
      | ""    |
      | "124" |

    Scenario: Navigation to art gallery page
      Given I am on the remove art page
      When I press the back to gallery button
      Then I should see the gallery page