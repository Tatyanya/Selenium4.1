package com.epam.tam.module4.task1.page_object.TR;

import com.epam.tam.module4.task1.page_object.AbstractPage;
import com.epam.tam.module4.task1.util.TimeOutUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TRAllProductPage extends AbstractPage {

    public TRAllProductPage() {
        super();
        PageFactory.initElements(this.driver, this);
    }

    private WebElement resourceLink(String arg) {
        return driver.findElement(By.xpath("//div[@class='list-of-links']//a[contains(text(),'" + arg + "')]"));
    }

    @FindBys(@FindBy(xpath = "//div[@class='list-of-links']//self::div[@class='col-xs-12 col-sm-4 column']"))
    public List<WebElement> columnElements;


    public int countOfColunm() {
        return columnElements.size();
    }

    public void openResourceLink(String arg) {
        resourceLink(arg).click();
        TimeOutUtils.sleepInSeconds(2);


    }

}


