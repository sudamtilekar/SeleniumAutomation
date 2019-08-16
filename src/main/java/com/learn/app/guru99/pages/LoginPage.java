package com.learn.app.guru99.pages;

import com.learn.app.guru99.BaseClass.TestBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends TestBaseClass {

    HomePage homePage;

    @FindBy(name = "uid")
    @CacheLookup
    WebElement loginName;

    @FindBy(name = "password")
    @CacheLookup
    WebElement loginPassWord;

    @FindBy(name = "btnLogin")
    @CacheLookup
    WebElement loginButton;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public void validateLoginPage(String expectedTitle) {
        String loginPageTitle = driver.getTitle();
        System.out.println("Login Page Title - Expected : " + loginPageTitle + "  Actual : " + expectedTitle);
        Assert.assertEquals(loginPageTitle, expectedTitle);
        System.out.println("Login page Load Validated");
    }

    public HomePage loginToApplication() {
        loginName.sendKeys(properties.getProperty("userName"));
        loginPassWord.sendKeys(properties.getProperty("passWord"));
        loginButton.submit();
        return new HomePage();
    }
}
