package com.qcadoo.selenium.navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.qcadoo.selenium.navigation.LogInTest.logInTest;
import static com.qcadoo.selenium.navigation.Url.getURL_LOGOUT;

/**
 * WebDriver
 * Created by Bartek on 18.08.2015.
 */
public class NavigateToURL {
    public static void main (String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get(getURL_LOGOUT());
        logInTest(driver);
    }
}
