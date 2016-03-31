package com.qcadoo.webdriver.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement;

/**
 * WebDriver
 * Created by Bartek on 22.03.2016.
 */
public class DashboardPO {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "userElement")
    private WebElement languageSelect;

    public DashboardPO(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
        PageFactory.initElements(driver,this);
    }

    public DashboardPO waitUntilLoginPresentOnDashboard(String login) {
        driver.switchTo().frame(0);
        wait.until(textToBePresentInElement(languageSelect,"Witaj " + login));
        return this;
    }
}
