package com.epam.tam.module4.task1.browsers;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Browser {
    private static final long IMPLICITY_WAIT = 60L;
    private static Browser instance;
/*
*//*    public static Browser getInstance() {
        if (instance == null) {
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT, TimeUnit.SECONDS);
            instance = new Browser();
        }
        return instance;
    }*//*

    private static void setDriver( ) {
        DesiredCapabilities capabilities = new DesiredCapabilities();

         // if (browserName.toLowerCase().contains("firefox")) {
              capabilities.setBrowserName("firefox");
         // } else if(browserName.toLowerCase().contains("chrome")){
         //     capabilities.setBrowserName("chrome");
         //   capabilities.internetExplorer();
       // }
        capabilities.setPlatform(Platform.WINDOWS);
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT, TimeUnit.SECONDS);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    public static RemoteWebDriver getDriver() {
        if (driver == null) {
            setDriver();
        }
        return driver;    }

    private static RemoteWebDriver driver;*/

    public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();

    @BeforeTest
    //Parameter will get browser from testng.xml on which browser test to run
    @Parameters("Browser")
    public void beforeClass(String myBrowser) throws MalformedURLException{

        RemoteWebDriver driver = null;

        if(myBrowser.equals("chrome")){
            DesiredCapabilities capability = new DesiredCapabilities().chrome();
            capability.setBrowserName("chrome");
            capability.setPlatform(Platform.WINDOWS);
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
        }
        else if(myBrowser.equals("firefox")){
            DesiredCapabilities capability = new DesiredCapabilities().firefox();
            capability.setBrowserName("firefox");
            capability.setPlatform(Platform.WINDOWS);
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
        }

        //setting webdriver
        setWebDriver(driver);

        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public static WebDriver getDriver() {
        return dr.get();
    }

    public void setWebDriver(RemoteWebDriver driver) {
        dr.set(driver);
    }

    @AfterClass
    public void afterClass(){
        getDriver().quit();
        dr.set(null);

    }

}
