Feature: Place an order

  Scenario: using default payment option
    Given I'm a guest customer
    And my billing details are
      | firstName | lastname | address_line1     | city  | state | postalCode | email              |
      | demo      | user     | 6300 Spring Creek | Plano | Texas | 75024      | askomdch@email.com |
# for some reason the below shape of data table is not working while using custom data table type
#      | firstName     | demo               |
#      | lastname      | user               |
#      | address_line1 | 6300 Spring Creek  |
#      | city          | Plano              |
#      | state         | Texas              |
#      | postalCode    | 75024              |
#      | email         | askomdch@email.com |
    And I have a product in the cart
    And I'm on the checkout page
    When I provide billing details
    And I place an order
    Then the order should be placed successfully