package com.framework.pageObject.navigation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Header {

    private static final Logger log = LoggerFactory.getLogger(Header.class);

    private WebDriver driver;
    private Header(WebDriver driver) { this.driver = driver;PageFactory.initElements(driver,this); }
    public static Header using(WebDriver driver) { return new Header(driver); }

    /**
     *  Header elements locators
     */

    @FindBy(id = "comparison-header")
    private WebElement compareItemHeaderBnt;

    @FindBy(id = "wishlist-header")
    private WebElement wishesHeaderBtn;

    @FindBy(id = "cart_popup_header")
    private WebElement backetHeaderBtn;

    public Header openComparePage() {
        this.compareItemHeaderBnt.click();
        log.info("Open 'Compare' page");
        return this;
    }
}
