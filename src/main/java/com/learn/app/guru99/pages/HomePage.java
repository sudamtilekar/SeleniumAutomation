package com.learn.app.guru99.pages;

import com.learn.app.guru99.BaseClass.TestBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends TestBaseClass {

    CustomerPage customerPage;

    @FindBy(xpath = "//a[contains(text(),'New Customer')]")
    @CacheLookup
    WebElement newCustomer;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void validateHomePage(String expectedLginedHomePageTitle, String homePageHeader) {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(homePageHeader)));
        String actualHomePageTitle = driver.getTitle();
        logger.info("Asserted = Home Page Title: Actual -" + actualHomePageTitle + ", Expected -" + expectedLginedHomePageTitle);
        Assert.assertEquals(actualHomePageTitle, expectedLginedHomePageTitle);
    }

    public CustomerPage navigateToCustomerPage() {
        newCustomer.click();
        return new CustomerPage();
    }

}
