package com.qcadoo.selenium.basicTests;

/**
 * WebDriver
 * Created by Bartek on 28.09.2015.
 */

import com.qcadoo.webdriver.drivermanager.DriverFactory;
import com.qcadoo.webdriver.pageobject.basic.products.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static com.qcadoo.webdriver.pageobject.basic.products.ProductsDetailsPO.GlobalTypeOfMaterial.INTERMEDIATE;

public class AddProductTest extends DriverFactory {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = getDriver();
    }

    @Test
    public void addProductsTest() {
        ProductsListPO productsListPO = new ProductsListPO(driver);
        productsListPO.goTo("Podstawowe", "Produkty");

        ProductsDetailsPO productsDetailsPO = productsListPO.addNewProduct();
        productsDetailsPO.typeProductNameAndNumber("ASD", "ASD")
                .selectGlobalTypeOfMaterial(INTERMEDIATE)
                .typeProductDescription("Produkt ASD")
                .selectProductUnit("szt")
                .saveProduct()
                .selectAdditionalUnit("para");

    }
//        driver.findElement(xpath("//a[.='Zapisz i nowy']")).click();
//
//        driver.findElement(By.id("window.mainTab.product.gridLayout.number_input")).clear();
//        driver.findElement(By.id("window.mainTab.product.gridLayout.number_input")).sendKeys("Nowy produkt wejściowy");
//        driver.findElement(By.id("window.mainTab.product.gridLayout.name_input")).clear();
//        driver.findElement(By.id("window.mainTab.product.gridLayout.name_input")).sendKeys("Nowy produkt wejściowy");
//        new Select(driver.findElement(By.id("window.mainTab.product.gridLayout.globalTypeOfMaterial_input"))).selectByVisibleText("półprodukt");
//        String ean_pr_wej = driver.findElement(By.id("window.mainTab.product.gridLayout.ean_input")).getAttribute("value");
//        new Select(driver.findElement(By.id("window.mainTab.product.gridLayout.category_input"))).selectByVisibleText("1");
//        driver.findElement(By.id("window.mainTab.product.gridLayout.description_input")).clear();
//        driver.findElement(By.id("window.mainTab.product.gridLayout.description_input")).sendKeys("Dodawanie nowego produktu wejściowego");
//        driver.findElement(By.xpath("//a[.='Zapisz i powrót']")).click();
//        assertTrue(isElementPresent(By.xpath("//span[.='Nowy produkt wejściowy']")));
//        assertTrue(isElementPresent(By.xpath("//span[.='Nowy produkt wyjściowy']")));
    }