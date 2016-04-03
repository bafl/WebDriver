package com.qcadoo.webdriver.pageobject.basic.products;

import com.qcadoo.webdriver.pageobject.AbstractPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * WebDriver
 * Created by Bartek on 30.03.2016.
 */
public class ProductsListPO extends AbstractPageObject {

    @FindBy(xpath = "//label[contains(.,'Dodajnowy')]")
    private WebElement addNewProduct;

    By addProduct = new By.ByXPath("//label[contains(.,'Dodajnowy')]");


    public ProductsListPO(WebDriver driver) {
        super(driver);
    }

    public ProductsDetailsPO addNewProduct() {
        wait.until(elementToBeClickable(addNewProduct)).click();
        return new ProductsDetailsPO(driver);
    }
}
