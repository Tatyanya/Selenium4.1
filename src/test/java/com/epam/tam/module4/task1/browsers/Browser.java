package com.epam.tam.module4.task1.browsers;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Browser {
    private static final long IMPLICITY_WAIT = 60L;
    private static Browser instance;

/*    public static Browser getInstance() {
        if (instance == null) {
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT, TimeUnit.SECONDS);
            instance = new Browser();
        }
        return instance;
    }*/

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

    private static RemoteWebDriver driver;


}
