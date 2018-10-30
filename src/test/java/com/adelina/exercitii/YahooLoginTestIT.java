package com.adelina.exercitii;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class YahooLoginTestIT {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.out.println("Run before each method (test) execution.");
    }

    @AfterMethod
    public void cleanUp() {
        System.out.println("Run after each method (test) execution.");
    }

    @Test
    public void demoTest1() {

        int a = 2 + 2;

        // Asserts that two ints are equal.
        // If they are not, an AssertionFailedError.
        // First param is the actual value.
        // Second param is the expected value.
        Assert.assertEquals(a, 4);
        Assert.assertTrue(a == 4);

//        Assert.assertFalse(a==4);
    }

    @Test
    public void testGoogleSearch() throws InterruptedException {
        // Optional, if not specified, WebDriver will search your path for chromedriver.
//        System.setProperty("webdriver.chrome.driver", "D:\\Tools\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com/xhtml");
        sleep(5000);  // Let the user actually see something!
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("ChromeDriver");
        searchBox.submit();
        sleep(5000);  // Let the user actually see something!
        driver.quit();
    }

    @Test
    public void testYahooMail() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://login.yahoo.com/?.src=fpctx&.intl=ro&.lang=ro-RO&authMechanism=primary&done=https%3A%2F%2Fro.yahoo.com%2F&eid=100&add=1");
        sleep(1000);
        WebElement loginBox = driver.findElement(By.id("login-username"));
        loginBox.sendKeys("adelina_selenium_test@yahoo.com");
        WebElement loginButton = driver.findElement(By.id("login-signin"));
        loginButton.click();
        sleep(1000);
        WebElement passwordBox = driver.findElement(By.id("login-passwd"));
        passwordBox.sendKeys("AdelinaSelenium7");
        WebElement authButton = driver.findElement(By.id("login-signin"));
        authButton.click();
        WebElement mailIcon = driver.findElement(By.id("uh-mail-link"));
        mailIcon.click();
        sleep(5000);
        driver.get("https://login.yahoo.com/account/logout?logout_all=1&.direct=2&crumb=fHUWlFobPTu&.done=https%3A%2F%2Fro.yahoo.com%2F");

    }

    @AfterClass
    public void closingTests() {
        driver.close();
    }


    @Test
    public void testStartMaximize() throws InterruptedException {
        driver = new ChromeDriver();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        Thread.sleep(3000);
    }
}

