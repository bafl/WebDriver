/**
 * WebDriver
 * Created by Bartek on 13.08.2015.
 */

package com.qcadoo.selenium.navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LogInTest {

public static void logInTest(WebDriver driver) {
        WebElement loginBox = driver.findElement(By.id("usernameInput"));
        WebElement passwordBox = driver.findElement(By.id("passwordInput"));
        WebElement loginButton = driver.findElement(By.cssSelector("#loginButton > span:nth-child(1)"));
        WebElement rememberMeChBox = driver.findElement(By.id("rememberMeCheckbox"));


        loginBox.sendKeys("superadmin");
        passwordBox.sendKeys("superadmin");
        rememberMeChBox.click();
        assertEquals("QCD MES :: login", driver.getTitle());

        System.out.println(loginButton.getTagName());

        System.out.println(loginBox.getCssValue("height"));
        System.out.println(loginBox.getLocation());
        System.out.println(passwordBox.getSize());
        assertEquals(loginBox.getSize(), passwordBox.getSize());
        System.out.println(loginButton.getText());
        assertTrue(loginButton.isDisplayed());
        System.out.println(loginButton.isDisplayed());
        System.out.println(rememberMeChBox.isSelected());
        assertEquals(true, rememberMeChBox.isEnabled());
        print(rememberMeChBox.isEnabled());
        print(rememberMeChBox.isSelected());

        loginButton.click();
    }

    public static void print(Object asd){
        System.out.println(asd);
    }

}
