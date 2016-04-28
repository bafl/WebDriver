package com.qcadoo.selenium.basicTests;

/**
 * WebDriver
 * Created by Bartek on 26.04.2016.
 */

import com.qcadoo.webdriver.drivermanager.DriverFactory;
import com.qcadoo.webdriver.pageobject.companystructure.SubassemblyDetailsPO;
import com.qcadoo.webdriver.pageobject.companystructure.SubassemblyListPO;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class FileUploadTest extends DriverFactory {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = getDriver();
    }

    @Test
    public void uploadFileToSubassembly() {
        SubassemblyListPO subassemblyListPO = new SubassemblyListPO(driver);
        subassemblyListPO.goTo("Struktura firmy", "Podzespoły");

        SubassemblyDetailsPO subassemblyDetailsPO = subassemblyListPO.addNewSubassembly()
                .typeSubassemblyNameAndNumber("ASD", "ASD")
                .selectWorkstationType()
                .saveEntity();
    }
}