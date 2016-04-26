package com.qcadoo.webdriver.pageobject.companystructure;

import com.qcadoo.webdriver.pageobject.AbstractPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * WebDriver
 * Created by Bartek on 26.04.2016.
 */
public class SubassemblyDetailsPO extends AbstractPageObject{

    @CacheLookup
    @FindBy(id = "window.mainTab.subassembly.gridLayout.number_input")
    private WebElement subassemblyNumberInput;

    @FindBy(id = "window.mainTab.subassembly.gridLayout.name_input")
    private WebElement subassemblyNameInput;

    @FindBy(id = "window.mainTab.subassembly.gridLayout.workstationType_openLookupButton")
    private WebElement workstationTypeLookup;
    @FindBy(css = "td[title=\"WST2-Sa\"] span")
    private WebElement workstationType;

    public SubassemblyDetailsPO(WebDriver driver) {
        super(driver);
    }

    public SubassemblyDetailsPO typeSubassemblyNameAndNumber(String number, String name) {
        waitForLoad();
        clearAndType(subassemblyNumberInput, number);
        clearAndType(subassemblyNameInput, name);
        return this;
    }

    public SubassemblyDetailsPO selectWorkstationType() {
        workstationTypeLookup.click();
        waitForLoad();
        switchToFrame(1);
        workstationType.click();
        switchToFrame(0);
        waitForLoad();
        return this;
    }
}
