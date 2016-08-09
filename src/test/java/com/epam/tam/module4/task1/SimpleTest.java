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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertTrue;

public class SimpleTest {
    private static final Logger LOG = LogManager.getLogger(SimpleTest.class);

    TRHomePage loginPage = new TRHomePage();
    TRAllProductPage allProductPage = new TRAllProductPage();

    OnePassPage onePassPage = new OnePassPage();

    protected static RemoteWebDriver driver= Browser.getDriver();


    @Parameters("browser")
    @BeforeClass
    public void beforeTest() {
        driver.manage().window().maximize();
    }

    @Test(description = "logo is displayed")
    public void openStartPage() {
        SoftAssert sa = new SoftAssert();
        LOG.info("Open start page");
        driver.navigate().to(Constants.START_URL);
        sa.assertEquals(driver.getTitle(), Constants.TR_HOME_PAGE_TITLE, "Incorrect title of page");
        sa.assertTrue(loginPage.companyLogo.isDisplayed(), "Logo is not displaing");
        sa.assertAll();
    }

    @Test(description = "logo is displayed", dependsOnMethods = "openStartPage")
    public void goToResources() {
        driver.navigate().to(Constants.START_URL);
        loginPage.openSignInPage();
        Assert.assertEquals(allProductPage.countOfColunm(), 3, "Incorrect quantity of column");
    }

    @Test(description = "logo is displayed", dependsOnMethods = "goToResources")
    public void displayLogoAndRedirectToHomePageFromResources() {
        driver.navigate().to(Constants.START_URL);
        loginPage.openSignInPage();
        loginPage.clickToLogo();
        Assert.assertEquals(driver.getTitle(), Constants.TR_HOME_PAGE_TITLE, "Incorrect title of page");
    }

    @Test(description = "presence of link", dependsOnMethods = "goToResources")
    public void presenceOfLink() {
        driver.navigate().to(Constants.START_URL);
        loginPage.openSignInPage();
        assertTrue(allProductPage.openResourceLinkIsDisplayed("Westlaw Classic"), "Link is not displaying");
    }

    @Test(description = "Go to WL", dependsOnMethods = "presenceOfLink")
    public void goToWL() {
        driver.navigate().to(Constants.START_URL);
        loginPage.openSignInPage();
        LOG.info("Open WL page");
        allProductPage.openResourceLink("Westlaw Classic");
        Assert.assertEquals(driver.getTitle(), Constants.WLC_PAGE_TITLE, "Incorrect title of page");
    }

    @Test( description = "LogIn to PL")
    public void failedLogIn() {
        driver.navigate().to(Constants.START_URL);
        loginPage.openSignInPage();
        allProductPage.openResourceLink("Westlaw Classic");
        onePassPage.loginOnePass(Constants.LOGIN, Constants.PASSWORD);
        assertTrue(onePassPage.getErrorMessage().equalsIgnoreCase(Constants.ALERT_MESSAGE), "Error message is not the same");
    }

    @AfterClass(description = "Stop Browser")
    public void stopBrowser() {
        driver.quit();
    }

}
