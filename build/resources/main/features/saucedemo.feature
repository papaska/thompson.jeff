Feature: Sauce Labs shopping demo
  1. Use the website https://www.saucedemo.com/ as the test site
  2. Create a test that logs in as the user: standard_user password: secret_sauce
  3. Add the “Sauce Labs Onesie” to the cart
  4. Add the “Sauce Labs Bike Light” to the cart
  5. Verify both items are in the cart

  @demo
  Scenario: SauceDemo

    Given I navigate to "https://www.saucedemo.com/"
    Then log in as user "standard_user" with password "secret_sauce"
    Then I add Sauce Labs Onesie to the cart
    Then I add Sauce Labs Bike Light to the cart
    Then I click the shopping cart
    And I validate both items are in the cart
    Then I complete the checkout process
    Then Fill in the shipping details with First name "Test" Last name "User" and Zipcode "12345" and click Continue
    #For the following step use Numbers only for the amounts, no dollar sign or symbols
    And I validate shipping method is "FREE PONY EXPRESS DELIVERY!"  Item total is "17.98" tax is "1.44" and Total is "19.42"
    Then I click Finish
    And I validate I am on the URL "https://www.saucedemo.com/checkout-complete.html"

