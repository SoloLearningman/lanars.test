package com.framework.tests;

import com.framework.utils.PropertyLoader;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ProdBaseTest {

    private static final Logger log = LoggerFactory.getLogger(ProdBaseTest.class);
    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        Properties props = PropertyLoader.loadTestSettings();
        String prodUrl = props.getProperty("production");

        DesiredCapabilities capabilitiesFirefox = new DesiredCapabilities();
        capabilitiesFirefox.setCapability("marionette", true);
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");

        driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(prodUrl);
        log.info("Setup browser successfully");

    }

    @AfterClass
    public void close() {
        driver.quit();
        log.info("Close browser");
    }
}
