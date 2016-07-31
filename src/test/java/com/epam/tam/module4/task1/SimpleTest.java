package com.epam.tam.module4.task1;

import com.epam.tam.module4.task1.browsers.Browser;
import com.epam.tam.module4.task1.page_object.OnePassPage;
import com.epam.tam.module4.task1.page_object.TR.TRAllProductPage;
import com.epam.tam.module4.task1.page_object.TR.TRHomePage;
import com.epam.tam.module4.task1.util.Constants;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleTest {
    private static final Logger LOG = LogManager.getLogger(SimpleTest.class);

    TRHomePage loginPage = new TRHomePage();
    TRAllProductPage allProductPage = new TRAllProductPage();

    OnePassPage onePassPage = new OnePassPage();

    protected static RemoteWebDriver driver = Browser.getInstance().getDriver();

    @BeforeClass(description = "Maximize window")
    public void maximizeBrowser() {
        driver.manage().window().maximize();
    }

    @Test()
    public void goToResources() {
        LOG.info("Open start page");
        driver.navigate().to(Constants.START_URL);
        loginPage.openSignInPage();
        Assert.assertEquals(allProductPage.countOfColunm(), 3, "Incorrect quantity of column");
    }

    @Test(description = "Go to WL", dependsOnMethods = "goToResources")
    public void goToWL() {
        LOG.info("Open WL page");
        allProductPage.openResourceLink("Westlaw Classic");
        Assert.assertEquals(driver.getTitle(), Constants.WLC_PAGE_TITLE, "Incorrect title of page");
    }

    @Test(dependsOnMethods = "goToWL", description = "LogIn to PL")
    public void failedLogIn() {
        onePassPage.loginOnePass(Constants.LOGIN, Constants.PASSWORD);
        Assert.assertTrue(onePassPage.getErrorMessage().equalsIgnoreCase(Constants.ALERT_MESSAGE), "Error message is not the same");
    }

    @AfterClass(description = "Stop Browser")
    public void stopBrowser() {
        driver.quit();
    }

}
