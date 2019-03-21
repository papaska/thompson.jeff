package saucedemo;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
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

    static WebDriverWait explicitWait;
    static WebDriver driver;



    @Before
    public void setUp() {

        // Establish WebDriver

        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\SeleniumWebdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        explicitWait = new WebDriverWait(driver, 10);


    }


    @After
    public void tearDown() {

        driver.close();
        driver.quit();

    }




}
