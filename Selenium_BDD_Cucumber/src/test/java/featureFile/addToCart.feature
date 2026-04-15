Feature: add productt to cart

  Background:
    Given launch the browser
    And navigate to the application by url "https://www.saucedemo.com"
    When enter username "standard_user" and password "secret_sauce"
    And click on login button in login page

  Scenario:
add single product in cart

    When inventory is displayed click on product "Sauce Labs Backpack"
    And click on add to cart button
    When product added to cart click on cart button
    Then validate the product name "Sauce Labs Backpack"
    When click on menu button
    And click on logout

  Scenario Outline:
adding multiple products in cart

    When inventory is displayed click on product "<Product Name>"
    And click on add to cart button
    When product added to cart click on cart button
    Then validate the product name "<Product Name>"
    When click on menu button
    And click on logout

    Examples:
      | Product Name             |
      | Sauce Labs Bike Light    |
      | Sauce Labs Bolt T-Shirt  |
      | Sauce Labs Fleece Jacket |
