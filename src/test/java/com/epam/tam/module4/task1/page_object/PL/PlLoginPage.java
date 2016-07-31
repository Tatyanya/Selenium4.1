package com.epam.tam.module4.task1.page_object.PL;

import com.epam.tam.module4.task1.page_object.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PlLoginPage extends AbstractPage {

    public PlLoginPage() {
        super();
        PageFactory.initElements(this.driver, this);
    }

    private WebElement onePassButton() {
        return driver.findElement(By.id("onePassLoginButton"));
    }

    public void clickOnePassButton() {
        onePassButton().click();
    }
}
