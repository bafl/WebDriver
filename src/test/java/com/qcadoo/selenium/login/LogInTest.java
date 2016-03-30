/**
 * WebDriver
 * Created by Bartek on 13.08.2015.
 */

package com.qcadoo.selenium.login;

import com.qcadoo.webdriver.drivermanager.DriverFactory;
import com.qcadoo.webdriver.pageobject.DashboardPO;
import com.qcadoo.webdriver.pageobject.LogInPO;
import com.qcadoo.webdriver.pageobject.LogInPO.MesLanguage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class LogInTest extends DriverFactory {

    private WebDriver driver;
    private DashboardPO dashboardPO;

    private String login = "admin";
    private String password = "admin";

    @Before
    public void setUp() throws Exception {
        driver = DriverFactory.getDriver();
        dashboardPO = new DashboardPO(driver);
    }

    @Test
    public void logInTest() throws Exception {
        DashboardPO dashboardPO = new LogInPO(driver)
                .get()
                .verifyTitle()
                .selectLanguage(MesLanguage.PL)
                .typeUsername(login)
                .typePassword(password)
                .checkRememberMe().submitLogInAndWaitForDashboard()
                .waitUntilLoginPresentOnDashboard(login);
    }
}

