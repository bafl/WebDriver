package com.qcadoo.webdriver.pageobject.basic.products;

import com.qcadoo.webdriver.pageobject.AbstractPageObject;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * WebDriver
 * Created by Bartek on 22.03.2016.
 */
public class ProductsDetailsPO extends AbstractPageObject<ProductsDetailsPO> {



    @CacheLookup
    @FindBy(id = "window.mainTab.product.gridLayout.number_input")
    private WebElement productNumberInput;

    @FindBy(id = "window.mainTab.product.gridLayout.name_input")
    private WebElement productNameInput;

    @FindBy(id = "window.mainTab.product.gridLayout.globalTypeOfMaterial_input")
    private WebElement globalTypeOfMaterialSelect;

    @FindBy(id = "window.mainTab.product.gridLayout.description_input")
    private WebElement descriptionInput;

    @FindBy(id = "window.mainTab.product.gridLayout.unit_input")
    private WebElement productUnitSelect;

    @FindBy(id = "window.mainTab.product.gridLayout.additionalUnit_input")
    private WebElement additionalUnitSelect;

    private List<WebElement> availableProductUnits;


    public ProductsDetailsPO(WebDriver driver) {
        super(driver);
    }

    public ProductsDetailsPO typeProductDescription(String productDescription) {
        clearAndType(descriptionInput, productDescription);
        return this;
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

    public ProductsDetailsPO selectProductUnit(String unit) {
        selectUnitHelper(unit,productUnitSelect);
        return this;
    }

    public ProductsDetailsPO selectAdditionalUnit(String additionalUnit) {
        selectUnitHelper(additionalUnit, additionalUnitSelect);
    return this;
    }

    private void selectUnitHelper(String unit, WebElement select) {
        Select unitSelect = new Select(select);
        if (!unitSelect.getFirstSelectedOption().getText().equals(unit)) {
            try {
                unitSelect.selectByVisibleText(unit);
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        }
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
}