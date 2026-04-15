Feature: search a product in flipkartsc

  Background:
    Given launching the browser
    And go to the application by url "https://www.flipkart.com/"

  Scenario:
open flipkart and search a product and print the price and verify clicked product

    When popup comes click on cancel button
    And search the product "iphone 16 pro max"
    When click on product "Apple iPhone 16 Pro Max (Natural Titanium, 256 GB)"
    And navigate to the new window
    When read the product price and print the product price
    And click on add to cart icon
    When navigate to cart
    Then verify the product name "Apple iPhone 16 Pro Max (Natural Titanium, 256 GB)"

  Scenario Outline:
add multiple products to cart

    When popup comes click on cancel button
    And search the product "<product name>"
    When click on product "<product>"
    And navigate to the new window
    When read the product price and print the product price
    And click on add to cart icon
    When navigate to cart
    Then verify the product name "<product>"

    Examples:
      | product name | product                           |
      | Samsung M07  | Samsung Galaxy M07 (Black, 64 GB) |
