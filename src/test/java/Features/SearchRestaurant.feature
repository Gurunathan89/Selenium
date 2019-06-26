Feature: Validate Search functionality of the takeaway.com website

  Scenario : As a customer, i want to perform search in takeaway.com website
    Given I open web page as guest
    Then I Search for restaurants
    And I Should see geo location with my current location
    Then I enter the pincode and search for the restaurants
    Then I click on search button
    And I Should see search results
    Then I should see options to filter the search results
    And I select select sorting as option
    Then I should see restaurants sorted based on rating


  Scenario : As a customer, i want to perform search in restaurant search results page
    Given I am on search results page
    Then I click on search icon
    And I Enter the restaurant name to search
    Then I should see the restaurant with the name i searched for

