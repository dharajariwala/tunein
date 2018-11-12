Feature: TuneIn Landing Page

  @Navigate
  Scenario: User is able to Navigate to TuneIn Web Page

    Given I open my browser
    When I Navigate to TuneIn url
    Then I should see TuneIn Landing Page with slides Text Href and Images are changed from Last Automation Run
    And I should Exit

