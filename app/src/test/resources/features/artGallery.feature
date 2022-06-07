Feature: VirtualGallery

  Background:
    Given Driver set up for virtual gallery page

  Scenario: Successfully getting title and photo for all the artworks
    Given I access virtual gallery page
    Then I should see title and photo of all the artworks

  Scenario: Successfully getting details for all the artworks on sale
    Given I access virtual gallery page
    Then I should see title, photo, and sale type of all the artworks on sale

  Scenario: Successfully getting photo only for all the artworks
    Given I access virtual gallery page
    Then I should see photo only of all the artworks