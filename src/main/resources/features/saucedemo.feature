Feature: Page Loading
  As a user,
  I want to load the page, type some text and check the behavior.

  Scenario: Simple page loading

    Given I navigate to "https://www.saucedemo.com/"
    Then log in as user "standard_user" with password "secret_sauce"
    Then I add “Sauce Labs Onesie” to the cart
    Then I add “Sauce Labs Bike Light” to the cart
    Then I validate both items are in the cart
