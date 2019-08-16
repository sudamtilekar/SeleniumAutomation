package com.learn.app.Customer;

import com.learn.app.guru99.BaseClass.TestBaseClass;
import com.learn.app.guru99.pages.CustomerPage;
import com.learn.app.guru99.pages.HomePage;
import com.learn.app.guru99.pages.LoginPage;
import com.learn.app.guru99.pages.LogoutPage;
import com.learn.app.guru99.utils.ReadExcelFileData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.temporal.Temporal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

public class AddCustomerTest extends TestBaseClass {

    HomePage homePage;
    LogoutPage logoutPage;
    CustomerPage customerPage;
    ReadExcelFileData readExcelFileData;


    public final String expectedTitle = "Guru99 Bank Home Page";
    public final String expectedLginedHomePageTitle = "Guru99 Bank Manager HomePage";
    public final String homePageHeader = "//td[contains(text(),'Manger Id :')]";
    public final String expectedCustomerPageTitle = "Guru99 Bank New Customer Entry Page";

    public AddCustomerTest() {
        PageFactory.initElements(driver, this);
    }

    @Test
    public void createNewCustomer() throws IOException {
        LoginPage loginPage = new LoginPage();
        logoutPage = new LogoutPage();
        readExcelFileData = new ReadExcelFileData();
        homePage = loginPage.loginToApplication();
        logger.info("Login Successfully");
        homePage.validateHomePage(expectedLginedHomePageTitle, homePageHeader);
        logger.info("Validated Home Page");
        customerPage = homePage.navigateToCustomerPage();
        logger.info("Navigated to New Customer Page");
        customerPage.validateCustomerPageTitle(expectedCustomerPageTitle);

//        Create Customer using SendKeys
//        customerPage.newCustomerCreate();
//        logger.info("New Customer Created using Find By Element");

//        Create Customer by passing Data from Excel
        customerPage.newCustomerCreateUsingExcelDataInput();
        logger.info("New Customer Created using Excel data");




//        logoutPage.logOutFromApp();
    }
}
