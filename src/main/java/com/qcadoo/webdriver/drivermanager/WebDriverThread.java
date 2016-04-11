package com.qcadoo.webdriver.drivermanager;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

public class WebDriverThread {

    private static WebDriver webDriver;

    private static final File firebug_path = new File("./src/main/resources/firebug-2.0.16-fx.xpi");
    private static final File firepath_path = new File("./src/main/resources/firepath-0.9.7.1-fx.xpi");

    private static final String operatingSystem = System.getProperty("os.name").toUpperCase();
    private static final String systemArchitecture = System.getProperty("os.arch");

    public static WebDriver getDriver() throws Exception {
        if (null == webDriver) {
            System.out.println(" ");
            System.out.println("Current Operating System: " + operatingSystem);
            System.out.println("Current Architecture: " + systemArchitecture);
            System.out.println("Current Browser Selection: Firefox");
            System.out.println(" ");
            FirefoxProfile firefoxProfile = new FirefoxProfile();
            firefoxProfile.addExtension(firebug_path);
            firefoxProfile.addExtension(firepath_path);

            String ext = "extensions.firebug.";
            String ext1 = "extensions.firepath.";

            firefoxProfile.setPreference(ext + "currentVersion", "2.0.16");
            firefoxProfile.setPreference(ext1 + "currentVersion", "0.9.7.1");
            firefoxProfile.setPreference(ext + "allPagesActivation", "on");
            firefoxProfile.setPreference(ext + "defaultPanelName", "net");
            firefoxProfile.setPreference(ext + "net.enableSites", true);

            webDriver = new FirefoxDriver(firefoxProfile);
            webDriver.manage().window().maximize();
        }

        return webDriver;
    }

    @AfterClass
    public static void quitDriver() {
        if (null != webDriver) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
