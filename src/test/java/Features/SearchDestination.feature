Feature: Validate placing of order as a guest

  @Testing
  Scenario Outline: As a guest, i want to subscribe to news letter
    Given I open web page as guest
    Then I Search for destination using "<country>"


    Examples:

      | country |
      | India |

