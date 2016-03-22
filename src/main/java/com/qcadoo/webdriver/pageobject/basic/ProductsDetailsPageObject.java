package com.qcadoo.webdriver.pageobject.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * WebDriver
 * Created by Bartek on 22.03.2016.
 */
public class ProductsDetailsPageObject {
    private WebDriver driver;
    private WebDriverWait wait;

	@FindBy(id = "window.mainTab.product.gridLayout.number_input")
	private WebElement productNumberInput;

    @FindBy(id = "window.mainTab.product.gridLayout.name_input")
    private WebElement productNameInput;


    public ProductsDetailsPageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
        PageFactory.initElements(driver,this);
    }


}
