package com.qcadoo.selenium.navigation;

/**
 * WebDriver
 * Created by Bartek on 28.09.2015.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static com.qcadoo.selenium.navigation.Url.getURL;

public class LogInImportedTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test000LogIn() throws Exception {
        driver.get(getURL());
        if (!driver.findElement(By.id("rememberMeCheckbox")).isSelected()) {
            driver.findElement(By.id("rememberMeCheckbox")).click();
        }
        new Select(driver.findElement(By.id("languageSelect"))).selectByVisibleText("Polski");
        driver.findElement(By.id("usernameInput")).clear();
        driver.findElement(By.id("passwordInput")).clear();
        driver.findElement(By.id("usernameInput")).sendKeys("superadmin");
        driver.findElement(By.id("passwordInput")).sendKeys("superadmin");

        driver.findElement(By.cssSelector("#loginButton > span")).click();

        String expectedTitle = "QCD MES - G³ówna";
        System.out.println("Title is: " + expectedTitle);

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.titleIs(expectedTitle));
    }

    @After
    public void quit(){
        driver.close();
        driver.quit();
    }


}
