Feature: Share Artist

    Background:
        Given Driver set up for artist details page

    Scenario: Successfully getting an artist link to share
        Given I access an artist's profile page
        When I click on the share artist button
        Then I want to generate a link of the artist profile to share
