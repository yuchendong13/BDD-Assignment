Feature: Filter Artwork
  This feature UI tests the art-gallery page and its functionality to filter artwork by sale type and art type among
  other attributes.

  Background:
    Given Driver set up for art gallery page
    And Gallery populated with test artwork

  Scenario: Filter all buy now sale items
    Given I am currently on the art gallery page
    When I select the buy now filter option
    And I press the filter by sale type button
    Then I should see all the art pieces with a buy now

  Scenario: Filter all auction sale items
    Given I am currently on the art gallery page
    When I select the auction filter option
    And I press the filter by sale type button
    Then I should see all the art pieces on auction

  Scenario: Filter all painting type art items
    Given I am currently on the art gallery page
    When I select the painting filter option
    And I press the filter by art type button
    Then I should see all the painting art pieces

  Scenario: Filter all print type art items
    Given I am currently on the art gallery page
    When I select the print filter option
    And I press the filter by art type button
    Then I should see all the print art pieces

  Scenario: Filter all sculpture type art items
    Given I am currently on the art gallery page
    When I select the sculpture filter option
    And I press the filter by art type button
    Then I should see all the sculpture art pieces

  Scenario: Filter all sale items below a certain price
    Given I am currently on the buy now art gallery page
    When I set the maximum price to 100
    And I press the filter by price button
    Then I should see all the art pieces with a buy now lower than the max price

  Scenario: Filter all sale items above a certain price
    Given I am currently on the buy now art gallery page
    When I set the minimum price to 100
    And I press the filter by price button
    Then I should see all the art pieces with a buy now greater than the min price

  Scenario: Filter all sale items within a price range
    Given I am currently on the buy now art gallery page
    When I set the minimum price to 100
    And I set the maximum price to 200
    And I press the filter by price button
    Then I should see all the art pieces with a buy now between the min and the max price

  Scenario: Filter auction items with less than a certain time remaining
    Given I am currently on the auction art gallery page
    When I select the lower than option
    And I set the hour to 1
    And I set the minutes to 0
    And I press the filter by time button
    Then I should see all the art pieces on auction with less than 1 hour remaining

  Scenario: Filter auction items with more than a certain time remaining
    Given I am currently on the auction art gallery page
    When I select the higher than option
    And I set the hour to 2
    And I set the minutes to 0
    And I press the filter by time button
    Then I should see all the art pieces on auction with more than 2 hours remaining