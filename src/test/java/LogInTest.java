/**
 * WebDriver
 * Created by Bartek on 13.08.2015.
 */
/**
 * WebDriver
 * Created by Bartek on 06.08.2015.
 */
package com.qcadoo.selenium.navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LogInTest {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.get("http://daily-build.qcadoo.org/login.html?timeout=true");

        WebElement loginBox = driver.findElement(By.id("usernameInput"));
        WebElement passwordBox = driver.findElement(By.id("passwordInput"));
        WebElement loginButton = driver.findElement(By.cssSelector("#loginButton > span:nth-child(1)"));

        loginBox.sendKeys("superadmin");
        passwordBox.sendKeys("superadmin");
        driver.findElement(By.id("rememberMeCheckbox")).click();
        assertEquals("QCD MES :: login", driver.getTitle());

        System.out.println(loginButton.getTagName());

        System.out.println(loginBox.getCssValue("height"));
        System.out.println(loginBox.getLocation());
        System.out.println(passwordBox.getSize());
        assertEquals(loginBox.getSize(), passwordBox.getSize());
        System.out.println(loginButton.getText());
        assertTrue(loginButton.isDisplayed());
        System.out.println(loginButton.isDisplayed());
        System.out.println(driver.findElement(By.id("rememberMeCheckbox")).isSelected());


        loginButton.click();
    }
}
