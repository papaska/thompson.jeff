package saucedemo;


import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.sl.In;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertTrue;

public class Step_Definitions {


    @Given("^I navigate to \"([^\"]*)\"$")
    public void iNavigateTo(String website) {
        //Navigate to the website provided. It's best if you use the fully qualified address (example https://www.saucedemo.com/)
       Hooks.driver.get(website);
    }

    @Then("^log in as user \"([^\"]*)\" with password \"([^\"]*)\"$")
    public void logInAsUserWithPassword(String username, String password){
        //type in the username
        Hooks.driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys(username);
        //type in the password
        Hooks.driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
        //click the login button
        Hooks.driver.findElement(By.xpath("//*[@id='login_button_container']/div/form/input[contains(@class,'btn_action')]")).click();
    }

    @Then("^I add “Sauce Labs Bike Light” to the cart$")
    public void iAddSauceLabsBikeLightToTheCart() {
        //wait for the bike light add to cart button to be active then click it
        WebElement bikeLight = Hooks.explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='item_0_title_link']/parent::div/following-sibling::div/button")));
        bikeLight.click();
    }


    @Then("^I add “Sauce Labs Onesie” to the cart$")
    public void iAddSauceLabsOnesieToTheCart() {
        //wait for the onesie add to cart button to be active then click it
        WebElement onesie = Hooks.explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='item_2_title_link']/parent::div/following-sibling::div/button")));
        onesie.click();
    }

    @Then("^I validate both items are in the cart$")
    public void iValidateBothItemsAreInTheCart() throws InterruptedException {

        //
        assertTrue(Hooks.explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='item_0_title_link']/div"))).isDisplayed());
        assertTrue(Hooks.explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='item_0_title_link']/div"))).isDisplayed());


    }

    @Then("I click the shopping cart")
    public void iClickTheShoppingCart() {
        //Click the shopping cart icon in the upper right of the screen
        WebElement cart = Hooks.explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='shopping_cart_container']")));
        cart.click();
    }
    @Then("I complete the checkout process")
    public void iCompleteTheCheckoutProcess() {
        //Click the checkout button in the bottom right
        WebElement cart = Hooks.explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cart_contents_container']/div/div[contains(@class,'cart_footer')]/a[contains(@class,'btn_action')]")));
        cart.click();

    }


    @Then("Fill in the shipping details with First name {string} Last name {string} and Zipcode {string} and click Continue")
    public void fillInTheShippingDetailsWithFirstNameLastNameAndZipcodeAndClickContinue(String firstName, String lastName, String zipCode) {
        //first name input
        WebElement first = Hooks.explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='first-name']")));
        first.sendKeys(firstName);
        //last name input
        WebElement last = Hooks.explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='last-name']")));
        last.sendKeys(lastName);
        //zipcode input
        WebElement zip = Hooks.explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='postal-code']")));
        zip.sendKeys(zipCode);
        //continue button
        Hooks.driver.findElement(By.xpath("//*[@id='checkout_info_container']/div/form/div[contains(@class,'checkout_buttons')]/input")).click();
    }

    @And("I validate shipping method is {string}  Item total is {string} tax is {string} and Total is {string}")
    public void iValidateCheckoutInfo(String shippingMethod, String itemTotal, String tax, String total) {

        //TODO parametrize the xpaths here to remove the hard codeded expected values
        //Validate Shipping method
        System.out.println("wait here");
        assertTrue(Hooks.explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='checkout_summary_container']/div/div[contains(@class,'summary_info')]/div[text()='"+ shippingMethod +"']"))).isDisplayed());
        //Validate Item Total (Number ONLY no dollar sign)
        assertTrue(Hooks.explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='checkout_summary_container']/div/div[contains(@class,'summary_info')]/div[text()='"+ itemTotal +"']"))).isDisplayed());
        //Validate Tax(Number ONLY no dollar sign)
        assertTrue(Hooks.explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='checkout_summary_container']/div/div[contains(@class,'summary_info')]/div[text()='" + tax + "']"))).isDisplayed());
        //Validate Total(Number ONLY no dollar sign)
        assertTrue(Hooks.explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='checkout_summary_container']/div/div[contains(@class,'summary_info')]/div[text()='"+ total +"']"))).isDisplayed());



    }

    @Then("I click Finish")
    public void iClickFinish() {
        //Click the finish button
        Hooks.driver.findElement(By.xpath("//*[@id='checkout_summary_container']/div/div/div/a[contains(@class,'btn_action cart_button')]")).click();

    }

    @And("I validate I am on the URL {string}")
    public void iValidateIAmOnTheURL(String urlToValidate) {
        String currentUrl = Hooks.driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, urlToValidate );
    }
}
