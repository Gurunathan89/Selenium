Feature: Validate Checkout functionality of the takeaway.com website

  Scenario : I want to validate checkout in takeaway.com website
    Given Given I am on search results page
    Then I choose the restaurant i want to order
    And I should see the restaurant overview page
    Then I should see price of the cart as zero


  Scenario : I want to validate checkout after choosing menu item in takeaway.com website
    Given I select the menu item from the restaurant
    Then I click on add button next to the menu item
    Then I should see the item gets added
    And I should see the price gets added to the cart
    When I click on the shopping cart
    Then I should see the detailed explanation of the price
    Then I should see the option to increase the count of the menu
    Then The price of the order should change accordingly
    And I should see edit and delete button
    And I should see proceed to checkout button as well