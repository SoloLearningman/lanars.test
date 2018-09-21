package com.framework.pageObject.items;

import com.framework.pageObject.navigation.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SSDNotebooks {

    private static final Logger log = LoggerFactory.getLogger(Header.class);
    private WebDriver driver;

    private SSDNotebooks(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static SSDNotebooks using(WebDriver driver) {
        return new SSDNotebooks(driver);
    }

    /**
     * SSDNotebooks page elements locators
     */

    @FindBy(name = "comparison_new_catalog")
    List<WebElement> compareList;

    public SSDNotebooks selectComparableItem() throws InterruptedException {

        for (int i = 0; i <= 1; i++) {
            compareList.get(i).click();
            Thread.sleep(1000);
            log.info("Select " + i + " Notebook element");
        }
        return this;
    }

}
