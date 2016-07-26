package com.epam.tam.module4.task1.page_object.PL;

import com.epam.tam.module4.task1.page_object.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PLHomePage extends AbstractPage{

    public WebElement headerLink(String arg) {
        return driver.findElement(By.xpath("//div[@class='header-contain']//a[contains(text(),'" + arg + "')]"));
    }


}
