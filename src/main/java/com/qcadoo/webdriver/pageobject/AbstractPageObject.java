package com.qcadoo.webdriver.pageobject;

import com.qcadoo.webdriver.pageobject.basic.products.ProductsDetailsPO;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
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
public abstract class AbstractPageObject<T extends AbstractPageObject<T>> {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(xpath = "//label[./text()='Zapisz']")
    private WebElement saveProductButton;

    private final By MENU_ARROW = new By.ByCssSelector("i");
    private final By MENU_CONTENT = new By.ByClassName("logoDropdownBoxContent");
    private final By SECOND_LEVEL_MENU_POSITIONS = new By.ByCssSelector("ul.subMenu > li span");

    public AbstractPageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void goTo(String firstLevel, String secondLevel) {
        if (driver.getTitle().contains("login") || !driver.getCurrentUrl().contains("daily-build.qcadoo.org")) {
            new LogInPO(driver).logInAsAdmin();
        }
        driver.switchTo().parentFrame();
        driver.findElement(MENU_ARROW).click();
        wait.until(visibilityOfElementLocated(MENU_CONTENT));

        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(linkText(firstLevel)))
                .sendKeys(Keys.ARROW_RIGHT)
                .perform();
        List<WebElement> secondLevelMenuPositionsList = driver.findElements(SECOND_LEVEL_MENU_POSITIONS);
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

    public void switchToFrame(int frameIndex){
        driver.switchTo().defaultContent();
        driver.switchTo().frame(frameIndex);
    }

    public void waitForSaveButtonEnabled(){
        WebElement saveButtonDivToBeEnabled = driver.findElement(By.xpath("//label[./text()='Zapisz']/../../../../.."));
        new WaitForElementAttribute("class","ribbonBigElement enabled",saveButtonDivToBeEnabled);
    }

    public void waitForLoad() {
        new WebDriverWait(driver, 5).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState == 'complete' && jQuery.active == 0").equals(true));
    }

    @SuppressWarnings("unchecked")
    public T saveEntity() {
        saveProductButton.click();
        waitForLoad();
        return (T) this;
    }


}