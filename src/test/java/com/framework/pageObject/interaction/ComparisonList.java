package com.framework.pageObject.interaction;

import com.framework.pageObject.navigation.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.NoSuchElementException;

public class ComparisonList {

    private static final Logger log = LoggerFactory.getLogger(Header.class);
    private WebDriver driver;

    public ComparisonList(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Page elements locators
     */

    @FindBy(xpath = "//*[@id=\"content-inner-block\"]/div[3]/div/section/div[4]/a")
    protected WebElement compareThisItemBtn;

    @FindBy(className = "comparison-t-row")
    protected List<WebElement> descriptionList;

    @FindBy(xpath = "//*[@id=\"compare-menu\"]/ul/li[2]")
    protected WebElement onlyDifferentSection;

    public void openCompareItemList() {
        compareThisItemBtn.click();
        log.info("Compare selected Items");
    }

    public void openDifferencesOnlyList() {
        onlyDifferentSection.click();
        log.info("Switch to 'Only differences'");
    }

    public int getCountFromAllParam() {

        int count = 0;

        for (WebElement elem : descriptionList) {
            if (elem.getAttribute("name").equals("different")) count++;
        }
        log.info("Get discrepancy from 'All params'");
        return count;
    }

    public int getCountFromOnlyDifferentParam() {

        int count = 0;

        for (WebElement elem : descriptionList) {
            if (elem.getAttribute("name").equals("different")) count++;
        }
        log.info("Get discrepancy from 'Only Differences'");
        return count;
    }
}
