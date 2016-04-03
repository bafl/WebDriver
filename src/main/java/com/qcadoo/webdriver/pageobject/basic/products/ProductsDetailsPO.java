package com.qcadoo.webdriver.pageobject.basic.products;

import com.qcadoo.webdriver.pageobject.AbstractPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

/**
 * WebDriver
 * Created by Bartek on 22.03.2016.
 */
public class ProductsDetailsPO extends AbstractPageObject {

    @FindBy(id = "window.mainTab.product.gridLayout.number_input")
    private WebElement productNumberInput;

    @FindBy(id = "window.mainTab.product.gridLayout.name_input")
    private WebElement productNameInput;

    @FindBy(xpath = "//span[contains(.,'Zapisz')]")
    private WebElement saveProductButton;

    @FindBy (id = "window.mainTab.product.gridLayout.globalTypeOfMaterial_input")
    private WebElement globalTypeOfMaterialSelect;


    public ProductsDetailsPO(WebDriver driver) {
        super(driver);
    }

    public enum GlobalTypeOfMaterial {
        NONE(""), COMPONENT("01component"), INTERMEDIATE("02intermediate"), FINAL_PRODUCT("03finalProduct"), WASTE("04waste");

        private String value;

        GlobalTypeOfMaterial(String type) {
            this.value = type;
        }

        public String getValue() {
            return value;
        }

    }

    public ProductsDetailsPO typeProductNameAndNumber(String number, String name) {
        waitForLoad();
        clearAndType(productNumberInput, number);
        clearAndType(productNameInput, name);
        return this;
    }

    public ProductsDetailsPO selectGlobalTypeOfMaterial(GlobalTypeOfMaterial materialType) {
        Select globalTypeOfMaterial = new Select(globalTypeOfMaterialSelect);
        globalTypeOfMaterial.selectByValue(materialType.getValue());
        return this;
    }
}