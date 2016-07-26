package com.epam.tam.module4.task1.page_object.TR;

import com.epam.tam.module4.task1.page_object.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TRAllProductPage extends AbstractPage {

      public WebElement resourceLink(String arg) {
        return driver.findElement(By.xpath("//div[@class='list-of-links']//a[contains(text(),'" + arg + "')]"));
    }

    public TRAllProductPage openResourceLink(String arg) {
        resourceLink(arg).click();
        return PageFactory.initElements(driver, TRAllProductPage.class);
    }

}


