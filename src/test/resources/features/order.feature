Feature: Order

  Scenario Outline: Order
    Given Login to app
    When On the search bar enter <productName> and choose this product
    And Swipe left
    And Tap on Add to cart button
    And Choose sku <skuName>
    And Tap on Add to cart button again
    Then Verify the following information the same productName= <productName>, skuName= <skuName>, quantity= <quantity>

    Examples:
      | productName   | skuName    | quantity |
      | Product exam1 | Sku2 exam1 | 1        |