package com.epam.tam.module4.task1.page_object.TR;

import com.epam.tam.module4.task1.page_object.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TRHomePage extends AbstractPage{

    public WebElement loginLink() {
        return driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
    }


    public TRHomePage openSignInPage() {
        loginLink().click();
        return PageFactory.initElements(driver, TRHomePage.class);
    }

}
