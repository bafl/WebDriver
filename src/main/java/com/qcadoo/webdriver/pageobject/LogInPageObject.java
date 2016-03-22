package com.qcadoo.webdriver.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * WebDriver
 * Created by Bartek on 22.03.2016.
 */
public class LogInPageObject {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final String URL = "http://daily-build.qcadoo.org/login.html?timeout=true";

    @FindBy(how = How.ID, id = "usernameInput")
    private WebElement usernameInput;

    @FindBy(how = How.ID, id = "passwordInput")
    private WebElement passwordInput;

    @FindBy(how = How.CSS, using = "a#loginButton")
    private WebElement loginButton;

    @FindBy(id = "rememberMeCheckbox")
    private WebElement rememberMeCheckbox;

    @FindBy(id = "languageSelect")
    private WebElement languageSelect;


    public LogInPageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
        PageFactory.initElements(driver, this);
    }

    public enum MesLanguage {
        PL("pl"), ENG("en");

        private String value;

        MesLanguage(String languageValue) {
            this.value = languageValue;
        }

        public String getValue() {
            return value;
        }

    }

    public LogInPageObject get() {
        driver.navigate().to(URL);
        return this;
    }

    public LogInPageObject typeUsername(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
        return this;
    }

    public LogInPageObject typePassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return this;
    }

    public LogInPageObject checkRememberMe() {
        if (!rememberMeCheckbox.isSelected()) {
            rememberMeCheckbox.click();
        }
        return this;
    }

    public LogInPageObject selectLanguage(MesLanguage language) {
        Select select = new Select(languageSelect);
        if (!Objects.equals(select.getFirstSelectedOption().getText(), language.getValue())) {
            select.selectByValue(language.getValue());
        }
        return this;
    }

    public DashboardPageObject submitLogInAndWaitForTitleToChange() {
        loginButton.click();
        wait.until(titleIs("QCD MES - G³ówna"));
        return new DashboardPageObject(driver);
    }

    public DashboardPageObject logInAsAdmin(){
        get();
        typeUsername("admin");
        typePassword("admin");
        selectLanguage(MesLanguage.PL);
        checkRememberMe();
        submitLogInAndWaitForTitleToChange();
        return new DashboardPageObject(driver);
    }
}
