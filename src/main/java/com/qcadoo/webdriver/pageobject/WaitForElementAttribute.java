package com.qcadoo.webdriver.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class WaitForElementAttribute implements ExpectedCondition<WebElement> {
        private String attribute;
        private String attributeValue;
        private WebElement element;

        public WaitForElementAttribute(final WebElement element) {
            this("readonly", "readonly", element);
        }

        public WaitForElementAttribute(final String attribute, final String attributeValue, final WebElement element) {
            this.attribute = attribute;
            this.attributeValue = attributeValue;
            this.element = element;
        }

        @Override
        public WebElement apply(WebDriver input) {
            try {
                if (attributeValue.equals(element.getAttribute(attribute))) {
                    return element;
                }
                return null;
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }