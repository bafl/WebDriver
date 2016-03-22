package com.qcadoo.selenium.basicTests;

/**
 * WebDriver
 * Created by Bartek on 28.09.2015.
 */

import com.qcadoo.webdriver.drivermanager.DriverFactory;
import com.qcadoo.webdriver.pageobject.MenuNavigation;
import com.qcadoo.webdriver.pageobject.basic.ProductsDetailsPageObject;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.ById;
import static org.openqa.selenium.By.ByXPath;

public class AddProductTest extends DriverFactory {
    private WebDriver driver;

    private final By saveButton = new ByXPath("//div[@id='window_ribbonContentWrapper']/div[2]/div/div/div[2]/div");
    private final By productNumberInputSelector = new ById("");
    private final By productNameInputSelector = new ById("window.mainTab.product.gridLayout.name_input");

    @Before
    public void setUp() throws Exception {
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        ProductsDetailsPageObject productsDetailsPO = new ProductsDetailsPageObject(driver);
    }

    @Test
    public void addProductsTest() throws Exception {
        MenuNavigation.goTo(driver, "Podstawowe", "Produkty");
    }
    @Test
    public void addProductsTest2() throws Exception {
        MenuNavigation.goTo(driver, "Technologie", "Technologie");


/*
        wait.until(frameToBeAvailableAndSwitchToIt(0));
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
        driver.findElement(xpath("//a[.='Zapisz i nowy']")).click();
*/
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

    private class ElementAttribute implements ExpectedCondition<WebElement> {
        private WebElement element;
        private final String attribute;
        private final String attributeValue;
        private final By locator;

        private ElementAttribute(final String attribute,final String attributeValue, final By locator) {
            this.attribute = attribute;
            this.attributeValue = attributeValue;
            this.locator = locator;
        }

        @Override
        public WebElement apply (WebDriver input){
            try {
                element = driver.findElement(locator);
                if (attributeValue.equals(driver.findElement(locator).getAttribute(attribute))) {
                    return element;
                }
                return null;
            } catch (Exception e) {
            }
            return null;

        }
    }

}

