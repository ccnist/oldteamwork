Feature: Sample Validations

  @learning
  Scenario Outline: Verify Clear Trip fares from mentioned locations
    Given I navigated to home page
    When I select round trip on home page
    And I select from "<from>" location
    And I select to "<to>" location
    And I select depart "<depart>" date
    And I select return "<return>" date
    And I select adult "<adult>" count
    And I select children "<children>" count
    And I select infant "<infant>" count
    And I select search flights button
    Then I should see list of planes available
    When I select second highest fares for both from and to
    Then I should be navigate to itinerary page with selected flight details
    Examples:
      |from     |to   |     depart      | return      |adult |children|infant|
      |hyderabad|mumbai|  24/10/2017     | 25/10/2017  |2     |2       |    1 |

#  @learning
#  Scenario Outline: Verify tickets on book my show
#    Given I navigated to home page
#    And I select "<movie>" movie and date "<date>" to watch
#    Then I should see list of theatres showing movie
#    When I select "<theatre>" to watch
#    And I select "<show>" to watch from available shows
#    Then I should see availability of tickets
#    And select adult "<adult>" children "<children>" tickets
#    Examples:
#      |movie     |theatre    |     date        |  show      |adult |children|
#      |baahubali |prasads    |  18/09/2017     |  matnee    |2     |2       |