package saucedemo;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
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
        //Click the shopping cart icon in the upper right of the screen
        Hooks.driver.findElement(By.xpath("//*[@id='shopping_cart_container']")).click();
        //
        assertTrue(Hooks.explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='item_0_title_link']/div"))).isDisplayed());
        assertTrue(Hooks.explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='item_0_title_link']/div"))).isDisplayed());
    

    }
}
