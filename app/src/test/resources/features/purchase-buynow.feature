Feature: Purchase Buy Now
  This feature tests to ensure buyers are registered and older than 16 to allow buying.

  Background:
    Given I am on the details page for a piece of art

  Scenario: User not logged in
    When I click the Buy Now button
    And I am not logged into an account
    Then Deny the buying attempt
    And Notify me to sign up or sign in

  Scenario: User logged in
    Given I am logged into an account
    When I click the Buy Now button
    Then Allow the Buy Now attempt

  Scenario Outline: User is too young
    Given I am <age> years old
    When I click the Buy Now button
    Then Deny the buying attempt
    And Notify me that I am too young
    Examples:
      |age|
      |"5"  |
      |"10" |
      |"15" |

  Scenario: User is old enough
    Given I am "20" years old
    When I click the Buy Now button
    Then Allow the Buy Now attempt
