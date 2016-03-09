/**
 * WebDriver
 * Created by Bartek on 13.08.2015.
 */

package com.qcadoo.selenium.navigation;

import com.qcadoo.selenium.DriverFactory;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


public class LogInTest extends DriverFactory {

    private static final String URL = "http://daily-build.qcadoo.org/login.html?timeout=true";
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() throws Exception {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void logInTest() throws Exception {
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver,10);
        driver.navigate().to(URL);

        WebElement usernameInput, passwordInput, loginButton, rememberMeChBox;
        usernameInput = driver.findElement(By.id("usernameInput"));
        passwordInput = driver.findElement(By.id("passwordInput"));
        loginButton = driver.findElement(By.cssSelector("a#loginButton"));
        rememberMeChBox = driver.findElement(By.id("rememberMeCheckbox"));

        assertEquals("QCD MES :: login", driver.getTitle());

        usernameInput.clear();
        passwordInput.clear();
        usernameInput.sendKeys("admin");
        passwordInput.sendKeys("admin");
        if (!rememberMeChBox.isSelected()) {
            rememberMeChBox.click();
        }
        loginButton.click();

        wait.until(titleIs("QCD MES - G³ówna"));
    }
}

