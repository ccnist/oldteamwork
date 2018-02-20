
Feature: As a end user, I should be able to navigate to respective pages
  Scenario Outline: Veriy links on home page
    Given I navigate to home page
    When I select "<link>" on page
    Then I should navigate to page
    Examples:
      |link  |
      | home |