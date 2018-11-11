Feature: TuneIn Landing Page

  @Navigate
  Scenario: User is able to Navigate to TuneIn Web Page

    Given I am a user
    When I Navigate to TuneIn url
    Then I should see TuneIn Landing Page
    And I should Exit

