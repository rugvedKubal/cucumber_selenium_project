Feature: Add to cart

  Scenario: Add one quantity from store
    Given I'm on the store page
    When I add a "Blue Shoes" to the cart
    Then I should see 1 "Blue Shoes" in the cart

  Scenario Outline: Add one quantity from store with examples
    Given I'm on the store page
    When I add a "<product_name>" to the cart
    Then I should see 1 "<product_name>" in the cart
    Examples:
      | product_name                    |
      | Anchor Bracelet                 |
      | Black Over-the-shoulder Handbag |
