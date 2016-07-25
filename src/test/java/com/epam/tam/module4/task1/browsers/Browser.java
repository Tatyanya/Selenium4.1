package com.epam.tam.module4.task1.browsers;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class Browser {
    private static final long IMPLICITY_WAIT = 60L;
    private static Browser instance;

    public static Browser getInstance() {
        if (instance == null) {
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT, TimeUnit.SECONDS);
            instance = new Browser();
        }
        return instance;
    }

    public RemoteWebDriver getDriver() {
        return driver;
    }

    private static RemoteWebDriver driver;
}
