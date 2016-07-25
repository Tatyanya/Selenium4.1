package com.epam.tam.module4.task1.page_object.PL;

import com.epam.tam.module4.task1.page_object.AbstractPage;
import com.epam.tam.module4.task1.page_object.TR.TRHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlLoginPage extends AbstractPage {


    public WebElement onePassButton() {
        return driver.findElement(By.id("onePassLoginButton"));

    }
    public PlLoginPage clickOnePassButton() {
        onePassButton().click();
        return PageFactory.initElements(driver, PlLoginPage.class);
    }
}
