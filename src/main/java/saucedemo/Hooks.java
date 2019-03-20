package saucedemo;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;



public class Hooks{

    public static String baseURL;
    public static WebDriverWait explicitWait;
    public static WebDriver driver;



    @Before
    public void setUp(Scenario scenario) throws Exception {
        System.out.println("Starting scenario name: " + scenario.getName());
        System.out.println("Starting scenario ID: " + scenario.getId());

        // Establish WebDriver
        System.setProperty("webdriver.firefox.marionette",System.getProperty("user.dir") + "\\SeleniumWebdrivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();



    }


    @After
    public void tearDown(Scenario scenario) {

        driver.close();
        driver.quit();

    }




}
