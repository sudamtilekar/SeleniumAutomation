package com.learn.app.guru99.pages;

import com.learn.app.guru99.BaseClass.TestBaseClass;
import com.learn.app.guru99.utils.ReadExcelFileData;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Random;

public class CustomerPage extends TestBaseClass {

    ReadExcelFileData readExcelFileData = new ReadExcelFileData();

    public static final String excelFilePath = "/src/main/resources/AddCustomer_TestData.xlsx";
    public String excelFinalFilePath = System.getProperty("user.dir") + excelFilePath;

    @FindBy(xpath = "//input[@name='name']")
    @CacheLookup
    WebElement customerName;

    @FindBy(xpath = "//input[@value='f']")
    @CacheLookup
    WebElement customerGenderFemale;

    @FindBy(css = "#dob")
    @CacheLookup
    WebElement customerDateOfBirth;

    @FindBy(xpath = "//textarea[@name='addr']")
    @CacheLookup
    WebElement customerAddress;

    @FindBy(xpath = "//input[@name='city']")
    @CacheLookup
    WebElement customerCity;

    @FindBy(xpath = "//input[@name='state']")
    @CacheLookup
    WebElement customerState;

    @FindBy(xpath = "//input[@name='pinno']")
    @CacheLookup
    WebElement customerPinNo;

    @FindBy(xpath = "//input[@name='telephoneno']")
    @CacheLookup
    WebElement customerTelephoneNo;

    @FindBy(xpath = "//input[@name='emailid']")
    @CacheLookup
    WebElement customerEmailID;

    @FindBy(xpath = "//input[@name='password']")
    @CacheLookup
    WebElement customerPassWord;

    @FindBy(xpath = "//input[@name='sub']")
    @CacheLookup
    WebElement customerSubmit;

    @FindBy(xpath = "//input[@name='res']")
    @CacheLookup
    WebElement customerReset;


    public CustomerPage() {
        PageFactory.initElements(driver, this);
    }

    //    validate Customer Landing Page
    public void validateCustomerPageTitle(String expectedCustomerPageTitle) {
        String customerPageTitle = driver.getTitle();
        logger.info("Asserted = Customer Page Title: - Actual " + expectedCustomerPageTitle + ", Expected : " + expectedCustomerPageTitle);
        Assert.assertEquals(customerPageTitle, expectedCustomerPageTitle);

    }


    //    Create New Customer by entering data in all fields
    public void newCustomerCreate() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(customerName));

        customerName.sendKeys("Sudam");
        customerGenderFemale.click();
        customerDateOfBirth.sendKeys("06");
        customerDateOfBirth.sendKeys("01");
        customerDateOfBirth.sendKeys("2018");
        customerAddress.sendKeys("G 704 Kanchanpuram Wagholi");
        customerCity.sendKeys("Pune");
        customerState.sendKeys("Maharashtra");
        customerPinNo.sendKeys("412207");
        customerTelephoneNo.sendKeys("84" + String.valueOf(randomNumberGenerator(8)));
        customerEmailID.sendKeys("sudam_" + String.valueOf(randomNumberGenerator(6)) + "@gmail.com");
        customerPassWord.sendKeys("Welcome123");
    }

    public void newCustomerCreateUsingExcelDataInput() {

        HashMap<String, String> newCustomerInputData = readExcelFileData.readExcelDataAndWriteToMAP("AddCustomerData", excelFinalFilePath);
        logger.info("Hash Map Values for New Customer Create are - " + newCustomerInputData);
        customerName.sendKeys(newCustomerInputData.get("Customer Name"));
        if (newCustomerInputData.get("Gender") == "F")
            customerGenderFemale.click();
        customerDateOfBirth.sendKeys(newCustomerInputData.get("DateOfBirthDay"));
        customerDateOfBirth.sendKeys(newCustomerInputData.get("DateOfBirthMonth"));
        customerDateOfBirth.sendKeys(newCustomerInputData.get("DateOfBirthYear"));
        customerAddress.sendKeys(newCustomerInputData.get("Address"));
        customerCity.sendKeys(newCustomerInputData.get("City"));
        customerState.sendKeys(newCustomerInputData.get("State"));
        customerPinNo.sendKeys(newCustomerInputData.get("PIN"));
        customerTelephoneNo.sendKeys(newCustomerInputData.get("Mobile Number") + String.valueOf(randomNumberGenerator(8)));
        customerEmailID.sendKeys(newCustomerInputData.get("E-mail") + String.valueOf(randomNumberGenerator(6)) + "@gmail.com");
        customerPassWord.sendKeys(newCustomerInputData.get("Password"));

//        Clear data from Map
        newCustomerInputData.clear();
    }

    public String randomNumberGenerator(int maxNumbers) {
        Random random = new Random();
        String generatedRandomNumberString = "";
        for (int i = 0; i < maxNumbers; i++) {
            int randomNumber = random.nextInt(9);
            generatedRandomNumberString = generatedRandomNumberString + randomNumber;
        }
        logger.info("Random Number Values are: " + generatedRandomNumberString);
        return generatedRandomNumberString;
    }


//    Save Customer

//    Update Customer

//    Delete Customer

}
