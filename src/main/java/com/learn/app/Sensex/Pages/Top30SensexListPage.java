package com.learn.app.Sensex.Pages;

import com.learn.app.guru99.BaseClass.TestBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Top30SensexListPage extends TestBaseClass {

    WebDriverWait wait;
    @FindBy(xpath = "//a[@title='Bajaj Finance Ltd.']")
    @CacheLookup
    WebElement bajajFinanceLtd;

    @FindBy(xpath = "//div[@class='dataList']/parent::div[@class='dataContainer']")
    @CacheLookup
    WebElement top30SensexList;

    public static final String companyNameToGetChangeUpValue = "bajaj-finance-ltd";
    public String companyNameToGetChangeUpValueElementValue = "";

    @FindBy(xpath = "//div[@data-seo='" + companyNameToGetChangeUpValue + "']/parent::li/following-sibling::li//span[@class='change up']")
    WebElement companyNameToGetChangeUpValueElement;

    @FindBy(xpath = "//div[@class='flag iBlock spriteMkt']/following-sibling::p/a")
    WebElement listOfCompaniesBeforeCompanyNameElement;

    public void setListOfCompaniesBeforeCompanyName() {
        int count = driver.findElements(By.xpath("//div[@class='flag iBlock spriteMkt']/following-sibling::p/a")).size();
        if(count)
    }

    public Top30SensexListPage() {
        PageFactory.initElements(driver, this);
    }

    public void validateTop30SensexPage() {
        Actions actions = new Actions(driver);
        actions.moveToElement(top30SensexList).click().build().perform();
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(bajajFinanceLtd));
        logger.info("Top 30 Sensex Page loaded Successfully");
    }

    public void validateTtitleOfTop30SensexPage(String top30SensexPageTitle) {
        String actualTop30SensexPageTitle = driver.getTitle();
        logger.info("Top 30 Sensex Page Title is : " + actualTop30SensexPageTitle);
        Assert.assertTrue(actualTop30SensexPageTitle.contains(top30SensexPageTitle));
    }

    public void getCurrentChangeUpValueOfCompany() {
        String companyNameToGetChangeUpValueElementValue = companyNameToGetChangeUpValueElement.getText();
        logger.info("Current Value of Company '" + companyNameToGetChangeUpValue + "' is - " + companyNameToGetChangeUpValueElementValue);
    }
}
