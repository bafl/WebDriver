package com.qcadoo.webdriver.pageobject.companystructure;

import com.qcadoo.webdriver.pageobject.AbstractPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

/**
 * WebDriver
 * Created by Bartek on 26.04.2016.
 */
public class SubassemblyListPO extends AbstractPageObject {

    @FindBy(xpath = "//label[contains(.,'Dodajnowy')]")
    private WebElement addNewSubassembly;

    public SubassemblyListPO(WebDriver driver) {
        super(driver);
    }

    public SubassemblyDetailsPO addNewSubassembly() {
        wait.until(elementToBeClickable(addNewSubassembly)).click();
        return new SubassemblyDetailsPO(driver);
    }
}
