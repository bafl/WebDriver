package com.qcadoo.selenium.basicTests;

/**
 * WebDriver
 * Created by Bartek on 28.09.2015.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static com.qcadoo.selenium.navigation.Url.getURL;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class AddProductTest {
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void test111AddProduct() throws Exception {
        driver.navigate().to(getURL());
       // logInTest(driver);
        driver.findElement(By.cssSelector("i")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if ("logoDropdownBox open".equals(driver.findElement(By.xpath("//div[@id='mainTopMenu']/div[2]")).getAttribute("class")))
                    break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.id("firstLevelButton_basic")));
        builder.build().perform();

        driver.findElement(By.linkText("Produkty")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if ("ribbonBigElement enabled".equals(driver.findElement(By.xpath("//div[@id='window_ribbonContentWrapper']/div/div/div/div[2]/div")).getAttribute("class")))
                    break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        driver.findElement(By.xpath("//label[.='Dodajnowy']")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if ("ribbonBigElement enabled".equals(driver.findElement(By.xpath("//div[@id='window_ribbonContentWrapper']/div/div/div/div[2]/div")).getAttribute("class")))
                    break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        driver.findElement(By.id("window.mainTab.product.gridLayout.number_input")).clear();
        driver.findElement(By.id("window.mainTab.product.gridLayout.number_input")).sendKeys("Nowy produkt wyjściowy");
        driver.findElement(By.id("window.mainTab.product.gridLayout.name_input")).clear();
        driver.findElement(By.id("window.mainTab.product.gridLayout.name_input")).sendKeys("Nowy produkt wyjściowy");
        new Select(driver.findElement(By.id("window.mainTab.product.gridLayout.globalTypeOfMaterial_input"))).selectByVisibleText("półprodukt");
        // ERROR: Caught exception [ERROR: Unsupported command [getEval |  | ]]
        String ean = driver.findElement(By.id("window.mainTab.product.gridLayout.ean_input")).getAttribute("value");
        new Select(driver.findElement(By.id("window.mainTab.product.gridLayout.category_input"))).selectByVisibleText("1");
        driver.findElement(By.id("window.mainTab.product.gridLayout.description_input")).clear();
        driver.findElement(By.id("window.mainTab.product.gridLayout.description_input")).sendKeys("Dodawanie nowego produktu wyjściowego");
        driver.findElement(By.xpath("//a[.='Zapisz i nowy']")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if ("ribbonBigElement enabled".equals(driver.findElement(By.xpath("//div[@id='window_ribbonContentWrapper']/div/div/div/div[2]/div")).getAttribute("class")))
                    break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        driver.findElement(By.id("window.mainTab.product.gridLayout.number_input")).clear();
        driver.findElement(By.id("window.mainTab.product.gridLayout.number_input")).sendKeys("Nowy produkt wejściowy");
        driver.findElement(By.id("window.mainTab.product.gridLayout.name_input")).clear();
        driver.findElement(By.id("window.mainTab.product.gridLayout.name_input")).sendKeys("Nowy produkt wejściowy");
        new Select(driver.findElement(By.id("window.mainTab.product.gridLayout.globalTypeOfMaterial_input"))).selectByVisibleText("półprodukt");
        // ERROR: Caught exception [ERROR: Unsupported command [getEval |  | ]]
        String ean_pr_wej = driver.findElement(By.id("window.mainTab.product.gridLayout.ean_input")).getAttribute("value");
        new Select(driver.findElement(By.id("window.mainTab.product.gridLayout.category_input"))).selectByVisibleText("1");
        driver.findElement(By.id("window.mainTab.product.gridLayout.description_input")).clear();
        driver.findElement(By.id("window.mainTab.product.gridLayout.description_input")).sendKeys("Dodawanie nowego produktu wejściowego");
        driver.findElement(By.xpath("//a[.='Zapisz i powrót']")).click();
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if ("ribbonBigElement enabled".equals(driver.findElement(By.xpath("//div[@id='window_ribbonContentWrapper']/div/div/div/div[2]/div")).getAttribute("class")))
                    break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
        // ERROR: Caught exception [ERROR: Unsupported command [keyUp | gs_name | \13]]
        for (int second = 0; ; second++) {
            if (second >= 60) fail("timeout");
            try {
                if ("ribbonBigElement enabled".equals(driver.findElement(By.xpath("//div[@id='window_ribbonContentWrapper']/div/div/div/div[2]/div")).getAttribute("class")))
                    break;
            } catch (Exception e) {
            }
            Thread.sleep(1000);
        }

        assertTrue(isElementPresent(By.xpath("//span[.='Nowy produkt wejściowy']")));
        assertTrue(isElementPresent(By.xpath("//span[.='Nowy produkt wyjściowy']")));
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

