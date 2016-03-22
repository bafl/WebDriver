package com.qcadoo.webdriver.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * WebDriver
 * Created by Bartek on 22.03.2016.
 */
public class MenuNavigation {

    private static final By menuArrow = new By.ByCssSelector("i");
    private static final By menuContent = new By.ByClassName("logoDropdownBoxContent");
    private static final By secondLevelMenuPositions = new By.ByCssSelector("ul.subMenu > li span");


    public static void goTo(WebDriver driver, String firstLevel, String secondLevel){
        WebDriverWait wait = new WebDriverWait(driver,5);
        if (driver.getTitle().contains("login")|| !driver.getCurrentUrl().contains("daily-build.qcadoo.org")){
            new LogInPageObject(driver).logInAsAdmin();
        }
        driver.findElement(menuArrow).click();
        wait.until(visibilityOfElementLocated(menuContent));

        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(linkText(firstLevel)));
        builder.sendKeys(Keys.ARROW_RIGHT);
        builder.perform();
        List<WebElement> secondLevelMenuPositionsList = driver.findElements(secondLevelMenuPositions);
        for (int i = 0; i < secondLevelMenuPositionsList.size(); i++){
            String label = driver.findElement(cssSelector("a.maintainHover span")).getText();
            if (!label.equals(secondLevel)){
                builder.sendKeys(Keys.ARROW_DOWN).perform();
            } else {
                builder.sendKeys(Keys.ENTER).perform();
                break;
            }
        }
    }
}
