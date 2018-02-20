Feature: Learn Collection using E Rail

  Scenario Outline: Verify trains from boarding to desitnation
    Given I navigated to home page
    When I search "<from>" to "<to>" trains list
    And I select "<date>" of travel with "<coach>" type
    Then I should see list of trains available
    Examples:
    |  from         |  to     | date   |  coach |
    | secuderabad   |  Ongole |        |         |