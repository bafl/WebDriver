package com.qcadoo.selenium.navigation;

/**
 * WebDriver
 * Created by Bartek on 18.08.2015.
 */
public class Url {
    private static String baseURLLogout = "http://test-buka.qcadoo.org/login.html?timeout=true";
    private static String baseURL = "http://test-buka.qcadoo.org/main.html";

    public static String getURL_LOGOUT() {
        return baseURLLogout;
    }

    public static String getURL() {
        return baseURL;
    }

}
