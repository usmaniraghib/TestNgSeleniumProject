package com.raghib.testngwithxml;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserTest {
    ChromeOptions options = null;
    WebDriver webDriverObj = null;
    String expectedTitle = "Google";

    @Test
    public void googlePageLoadingTest() {
        String currentTitle = webDriverObj.getTitle();
        System.out.println("currentTitle : "+currentTitle);
        Assert.assertEquals(currentTitle, expectedTitle);
    }

    @BeforeTest
    public void beforeTest() {
        // Chrome Browser
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webDriverObj = new ChromeDriver(options);
        webDriverObj.manage().window().maximize();
        webDriverObj.manage().deleteAllCookies();

        webDriverObj.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        webDriverObj.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriverObj.get("https://www.google.com/");

        //Refresh the browser.
        webDriverObj.navigate().refresh();
    }

    @AfterTest
    public void afterTest() {
        try {
            if (webDriverObj != null) {
                System.out.println("Driver Need to Close");
            } else {
                System.out.println("Driver Still Open");
            }
        } catch (Exception e) {
            System.out.println("Nothing to do with it");
        } finally {
            System.out.println("Finally Block - To close the driver");
            webDriverObj.quit();
        }
    }
}
