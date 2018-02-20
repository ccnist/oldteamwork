Feature: Programms to Learns

  Scenario Outline: Palindrome
    Given I have "<input>" to programme
    Then I should see expected "<output>"
    Examples:
      | input | output |
      | madam | true   |
      | 21212 | true   |
      | hello | false  |
      | ****  | true   |


  Scenario: Generate Random Alphanumeric
    Given I have to generate random alphanumeric

  Scenario: Generate all possible uniq Alaphanumeric from given
    Given I have give one alphanumeric
    Then I should produce all possible cases



