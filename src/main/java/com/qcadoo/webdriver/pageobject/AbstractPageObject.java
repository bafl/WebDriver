package com.qcadoo.webdriver.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * WebDriver
 * Created by Bartek on 30.03.2016.
 */
public abstract class AbstractPageObject {
    protected WebDriver driver;
    protected WebDriverWait wait;

    private static final By menuArrow = new By.ByCssSelector("i");
    private static final By menuContent = new By.ByClassName("logoDropdownBoxContent");
    private static final By secondLevelMenuPositions = new By.ByCssSelector("ul.subMenu > li span");

    public AbstractPageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void goTo(String firstLevel, String secondLevel) {
        if (driver.getTitle().contains("login") || !driver.getCurrentUrl().contains("daily-build.qcadoo.org")) {
            new LogInPO(driver).logInAsAdmin();
        }
        driver.findElement(menuArrow).click();
        wait.until(visibilityOfElementLocated(menuContent));

        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(linkText(firstLevel)))
                .sendKeys(Keys.ARROW_RIGHT)
                .perform();
        List<WebElement> secondLevelMenuPositionsList = driver.findElements(secondLevelMenuPositions);
        for (int i = 0; i < secondLevelMenuPositionsList.size(); i++) {
            String label = driver.findElement(cssSelector("a.maintainHover span")).getText();
            if (!label.equals(secondLevel)) {
                builder.sendKeys(Keys.ARROW_DOWN).perform();
            } else {
                builder.sendKeys(Keys.ENTER).perform();
                break;
            }
        }
        driver.switchTo().frame(0);
    }

    public void clearAndType(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    protected class ElementAttribute implements ExpectedCondition<WebElement> {
        private final String attribute;
        private final String attributeValue;
        private final WebElement element;

        public ElementAttribute(final WebElement element) {
            this("readonly", "readonly", element);
        }

        public ElementAttribute(final String attribute, final String attributeValue, final WebElement element) {
            this.attribute = attribute;
            this.attributeValue = attributeValue;
            this.element = element;
        }

        @Override
        public WebElement apply (WebDriver input){
            try {
                if (attributeValue.equals(element.getAttribute(attribute))) {
                    return element;
                }
                return null;
            } catch (Exception e) {
            }
            return null;

        }
    }
}

