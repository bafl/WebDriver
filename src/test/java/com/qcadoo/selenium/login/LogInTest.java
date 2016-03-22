/**
 * WebDriver
 * Created by Bartek on 13.08.2015.
 */

package com.qcadoo.selenium.login;

import com.qcadoo.webdriver.drivermanager.DriverFactory;
import com.qcadoo.webdriver.pageobject.LogInPageObject;
import com.qcadoo.webdriver.pageobject.LogInPageObject.MesLanguage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;


public class LogInTest extends DriverFactory {

    private WebDriver driver;
    private LogInPageObject logInPageObject;

    @Before
    public void setUp() throws Exception {
        driver = DriverFactory.getDriver();
        logInPageObject = new LogInPageObject(driver);
        logInPageObject.get();
    }

    @Test
    public void logInTest() throws Exception {
        assertEquals("QCD MES :: login", driver.getTitle());
        logInPageObject.selectLanguage(MesLanguage.PL);
        logInPageObject.typeUsername("admin");
        logInPageObject.typePassword("admin");
        logInPageObject.checkRememberMe();
        logInPageObject.submitLogInAndWaitForTitleToChange();
    }
}

