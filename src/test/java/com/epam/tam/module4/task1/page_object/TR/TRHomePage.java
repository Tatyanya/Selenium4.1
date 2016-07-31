package com.epam.tam.module4.task1.page_object.TR;

import com.epam.tam.module4.task1.page_object.AbstractPage;
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

    public void openSignInPage() {
        loginLink.click();
    }

}
