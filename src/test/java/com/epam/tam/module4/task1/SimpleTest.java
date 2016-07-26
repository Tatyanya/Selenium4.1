package com.epam.tam.module4.task1;

import com.epam.tam.module4.task1.browsers.Browser;
import com.epam.tam.module4.task1.page_object.OnePassPage;
import com.epam.tam.module4.task1.page_object.TR.TRAllProductPage;
import com.epam.tam.module4.task1.page_object.TR.TRHomePage;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleTest {

    private static final String LOGIN = "someTextForUserName";
    private static final String PASSWORD = "somePassword";
    private static final String START_URL = "http://tr.com";
    private static final String WLC_PAGE_TITLE = "Westlaw Signon";
    private static final String ALERT_MESSAGE = "Your username and/or password do not match our records. Please try again.";

    TRHomePage loginPage = new TRHomePage();
    TRAllProductPage allProductPage = new TRAllProductPage();

    OnePassPage onePassPage = new OnePassPage();

    protected static RemoteWebDriver driver = Browser.getInstance().getDriver();

    @BeforeClass(description = "Maximize window")
    public void maximizeBrowser() {
        driver.manage().window().maximize();
    }

    @Test(description = "Go to WL")
    public void goToWL() {
        driver.navigate().to(START_URL);
        loginPage.openSignInPage();
        allProductPage.openResourceLink("Westlaw Classic");
        Assert.assertEquals(driver.getTitle(), WLC_PAGE_TITLE, "incorrect title of page");
    }

    @Test(dependsOnMethods = "goToWL", description = "LogIn to PL")
    public void failedLogIn() {
        onePassPage.loginOnePass(LOGIN, PASSWORD);
        Assert.assertTrue(onePassPage.errorMessage().equalsIgnoreCase(ALERT_MESSAGE), "Error message is not the same");
    }

    @AfterClass(description = "Stop Browser")
    public void stopBrowser() {
        driver.quit();
    }

}
