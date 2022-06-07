Feature: Shipping Details

  Background:
    Given Driver set up for shipping details page

  Scenario: Entering Shipping Details
    Given That I'm on the art details page
    When When I click buy now on a artwork
    Then I want to be able to enter my shipping details


  Scenario: Notification for successful purchase
    Given I have clicked the buy now of an artwork
    When I click on the submit button
    Then I want a confirmation of my purchase.


