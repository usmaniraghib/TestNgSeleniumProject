package com.raghib.testngwithxml;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class UserTest {
    @Test
    public void myTest() {
        ChromeOptions options = null;
        WebDriver webDriverObj = null;
        String expectedTitle = "Google";
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        webDriverObj = new ChromeDriver(options);
        //webDriverObj = new ChromeDriver();
        webDriverObj.manage().window().maximize();
        webDriverObj.manage().deleteAllCookies();

        Duration duration = Duration.ofSeconds(30);
        webDriverObj.manage().timeouts().implicitlyWait(duration);
        webDriverObj.manage().timeouts().pageLoadTimeout(duration);
        webDriverObj.get("https://www.google.com/");

        //Refresh the browser.
        webDriverObj.navigate().refresh();

        String currentTitle = webDriverObj.getTitle();
        System.out.println("currentTitle : "+currentTitle);
        Assert.assertEquals(currentTitle, expectedTitle);

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
