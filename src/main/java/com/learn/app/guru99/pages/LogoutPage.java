package com.learn.app.guru99.pages;

import com.learn.app.guru99.BaseClass.TestBaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage extends TestBaseClass {

    @FindBy(xpath = "//a[contains(text(),'Log out')]")
    @CacheLookup
    WebElement logoutApp;

    public LogoutPage() {
        PageFactory.initElements(driver, this);
    }

    public void logOutFromApp() {
        Actions actions = new Actions(driver);
        actions.moveToElement(logoutApp).click().build().perform();
        driver.switchTo().alert().accept();
        driver.navigate().refresh();

    }
}
