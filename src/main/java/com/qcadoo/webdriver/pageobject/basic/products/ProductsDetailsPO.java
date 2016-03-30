package com.qcadoo.webdriver.pageobject.basic.products;

import com.qcadoo.webdriver.pageobject.AbstractPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


    public ProductsDetailsPO(WebDriver driver) {
        super(driver);
    }

    public ProductsDetailsPO typeProductNameAndNumber(String number, String name) {
//        wait.until(new ElementAttribute(saveProductButton));
        clearAndType(productNumberInput,number);
        clearAndType(productNameInput,name);
        return this;
    }
}
