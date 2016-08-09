package com.epam.tam.module4.task1.page_object;


import com.epam.tam.module4.task1.browsers.Browser;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    protected RemoteWebDriver driver;

    public AbstractPage() {
        this.driver = Browser.getDriver();
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public String getAlertDialogMsg() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void acceptAlertDialogMsg() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
