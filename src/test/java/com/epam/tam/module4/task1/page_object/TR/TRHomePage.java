package com.epam.tam.module4.task1.page_object.TR;

import com.epam.tam.module4.task1.page_object.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TRHomePage extends AbstractPage {

    public TRHomePage() {
        super();
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Login')]")
    private WebElement loginLink;

    @FindBy(xpath = "//header//a[contains(@href, '/en.html')]/span[contains(@class,'logo')]")
    public WebElement companyLogo;


    public void openSignInPage() {
        loginLink.click();
    }

    public void clickToLogo() {
        companyLogo.click();
    }

}
