package com.qcadoo.webdriver.pageobject.basic.products;

import com.qcadoo.webdriver.pageobject.AbstractPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * WebDriver
 * Created by Bartek on 30.03.2016.
 */
public class ProductsListPO extends AbstractPageObject {

    @FindBy(xpath = "//label[contains(.,'Dodajnowy')]")
    private WebElement addNewProduct;


    public ProductsListPO(WebDriver driver) {
        super(driver);
    }

    public ProductsDetailsPO addNewProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(addNewProduct)).click();
        return new ProductsDetailsPO(driver);
    }
}
