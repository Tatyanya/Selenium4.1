package com.epam.tam.module4.task1.page_object;

import com.epam.tam.module4.task1.page_object.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class OnePassPage extends AbstractPage {

    public WebElement onePassUsername() {
        return driver.findElement(By.name("Username"));
    }

    public WebElement onePassPassword() {
        return driver.findElement(By.id("Password"));
            }

    public WebElement onePassSignInButton() {
        return driver.findElement(By.cssSelector("button#SignIn"));
    }
    public WebElement errorMessage(){
        return driver.findElement(By.xpath("//*div[@id='errorMessageDialog']/span"));
    }

    public void loginOnePass(String login, String password) {
        onePassUsername().clear();
        onePassUsername().sendKeys(login);

        onePassPassword().clear();
        onePassPassword().sendKeys(password);

        onePassSignInButton().click();
    }


}

