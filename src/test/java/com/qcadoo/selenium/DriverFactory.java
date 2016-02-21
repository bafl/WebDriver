package com.qcadoo.selenium;

import org.junit.After;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriverThread> driverThread;

    @BeforeClass
    public static void instantiateDriverObject() {
        driverThread = new ThreadLocal<WebDriverThread>() {
            @Override
            protected WebDriverThread initialValue() {
                WebDriverThread webDriverThread = new WebDriverThread();
                return webDriverThread;
            }
        };
    }

    public static WebDriver getDriver() throws Exception {
        return driverThread.get().getDriver();
    }

    @After
    public void quitDriver() throws Exception {
        driverThread.get().quitDriver();
    }
}