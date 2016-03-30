package com.qcadoo.selenium.basicTests;

/**
 * WebDriver
 * Created by Bartek on 28.09.2015.
 */

import com.qcadoo.webdriver.drivermanager.DriverFactory;
import com.qcadoo.webdriver.pageobject.basic.products.ProductsDetailsPO;
import com.qcadoo.webdriver.pageobject.basic.products.ProductsListPO;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class AddProductTest extends DriverFactory {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void addProductsTest() throws Exception {
        ProductsListPO productsListPO = new ProductsListPO(driver);
        productsListPO.goTo("Podstawowe","Produkty");

        ProductsDetailsPO productsDetailsPO = productsListPO.addNewProduct();
        productsDetailsPO.typeProductNameAndNumber("ASD","ASD");




/*      wait.until(frameToBeAvailableAndSwitchToIt(0));
        wait.until(visibilityOfElementLocated(xpath("//label[.='Dodajnowy']"))).click();
        WebElement productNumberInput = wait.until(visibilityOfElementLocated(productNumberInputSelector));
        wait.until(new ElementAttribute("class","ribbonBigElement enabled",saveButton));

        productNumberInput.clear();
        productNumberInput.sendKeys("Nowy produkt wyjœciowy");
        WebElement productNameInput = driver.findElement(productNameInputSelector);
        productNameInput.clear();
        driver.findElement(id("window.mainTab.product.gridLayout.name_input")).sendKeys("Nowy produkt wyjœciowy");
        new Select(driver.findElement(id("window.mainTab.product.gridLayout.globalTypeOfMaterial_input"))).selectByVisibleText("pó³produkt");
        driver.findElement(id("window.mainTab.product.gridLayout.description_input")).clear();
        driver.findElement(id("window.mainTab.product.gridLayout.description_input")).sendKeys("Dodawanie nowego produktu wyjœciowego");
        driver.findElement(xpath("//a[.='Zapisz i nowy']")).click();*/

//        driver.findElement(By.id("window.mainTab.product.gridLayout.number_input")).clear();
//        driver.findElement(By.id("window.mainTab.product.gridLayout.number_input")).sendKeys("Nowy produkt wejœciowy");
//        driver.findElement(By.id("window.mainTab.product.gridLayout.name_input")).clear();
//        driver.findElement(By.id("window.mainTab.product.gridLayout.name_input")).sendKeys("Nowy produkt wejœciowy");
//        new Select(driver.findElement(By.id("window.mainTab.product.gridLayout.globalTypeOfMaterial_input"))).selectByVisibleText("pó³produkt");
//        String ean_pr_wej = driver.findElement(By.id("window.mainTab.product.gridLayout.ean_input")).getAttribute("value");
//        new Select(driver.findElement(By.id("window.mainTab.product.gridLayout.category_input"))).selectByVisibleText("1");
//        driver.findElement(By.id("window.mainTab.product.gridLayout.description_input")).clear();
//        driver.findElement(By.id("window.mainTab.product.gridLayout.description_input")).sendKeys("Dodawanie nowego produktu wejœciowego");
//        driver.findElement(By.xpath("//a[.='Zapisz i powrót']")).click();
//        assertTrue(isElementPresent(By.xpath("//span[.='Nowy produkt wejœciowy']")));
//        assertTrue(isElementPresent(By.xpath("//span[.='Nowy produkt wyjœciowy']")));
//    }

    }



}

