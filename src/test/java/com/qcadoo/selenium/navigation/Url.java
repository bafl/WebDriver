package com.qcadoo.selenium.navigation;

/**
 * WebDriver
 * Created by Bartek on 18.08.2015.
 */
public class Url {
    private static String URL_LOGOUT = "http://daily-build.qcadoo.org/login.html?timeout=true";
    private static String URL = "http://daily-build.qcadoo.org/";

    public static String getURL_LOGOUT() {
        return URL_LOGOUT;
    }

    public static String getURL() {
        return URL;
    }

}
