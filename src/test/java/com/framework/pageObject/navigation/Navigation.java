package com.framework.pageObject.navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class Navigation {

    private static final Logger log = LoggerFactory.getLogger(Header.class);
    private WebDriver driver;

    private Navigation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static Navigation using(WebDriver driver) {
        return new Navigation(driver);
    }

    /**
     * Navigation elements locators
     */

    @FindBy(name = "fat_menu_link")
    protected List<WebElement> mainCategoriesLink;

    @FindBy(id = "2416")
    protected WebElement noteBooksAndPC;
    @FindBy(xpath = "//*[@id=2416]/div/div[1]/div/ul/li[1]/a")
    protected WebElement notebooks;
    @FindBy(xpath = "//*[@id=\"content-inner-block\"]/div[2]/div[2]" +
            "/div/div[2]/div/div[1]/div[1]/div/div[3]/div/div/div[1]" +
            "/div[1]/div[3]/div[2]")
    protected WebElement ssdNotebooks;


    /**
     * Hover to certain main category
     *
     * @param attr
     * @return
     */
    public Navigation hoverCategory(String attr) {

        for (WebElement category : mainCategoriesLink) {

            if (category.getAttribute("data-title").equals(attr)) {
                Actions act = new Actions(driver);
                act.moveToElement(category).perform();
                log.info("Hover to " + attr);
                break;
            }
        }
        return this;
    }

    public Navigation
    openNotebooksCategory() {
        Actions act = new Actions(driver);
        act.moveToElement(noteBooksAndPC).build().perform();
        act.moveToElement(notebooks).click().build().perform();
        log.info("Open Notebooks Category page");
        return this;
    }

    public Navigation openSSDNotebooksPage() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");

        this.ssdNotebooks.click();
        log.info("Open SSD Notebooks List");
        return this;
    }
}
