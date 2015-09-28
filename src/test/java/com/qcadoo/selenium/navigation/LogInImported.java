package com.qcadoo.selenium.navigation;

/**
 * WebDriver
 * Created by Bartek on 28.09.2015.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static com.qcadoo.selenium.navigation.Url.getURL;
import static org.junit.Assert.fail;

public class LogInImported {
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test000LogIn() throws Exception {

        driver.get(getURL());
        new Select(driver.findElement(By.id("languageSelect"))).selectByVisibleText("Polski");
        driver.findElement(By.id("usernameInput")).clear();
        driver.findElement(By.id("usernameInput")).sendKeys("superadmin");
        driver.findElement(By.id("passwordInput")).clear();
        driver.findElement(By.id("passwordInput")).sendKeys("superadmin");
        if (!driver.findElement(By.id("rememberMeCheckbox")).isSelected()) {
            driver.findElement(By.id("rememberMeCheckbox")).click();
        }
        driver.findElement(By.cssSelector("#loginButton > span")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
