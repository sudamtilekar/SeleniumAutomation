package com.learn.app.guru99.Login;

import com.learn.app.guru99.BaseClass.TestBaseClass;
import com.learn.app.guru99.pages.HomePage;
import com.learn.app.guru99.pages.LoginPage;
import com.learn.app.guru99.pages.LogoutPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/* RUN CLASS FILE FROM TESTNG.XML*/

public class LoginGuru99PageTest extends TestBaseClass {

    public final String expectedTitle = "Guru99 Bank Home Page";
    public final String expectedLginedHomePageTitle = "Guru99 Bank Manager HomePage";
    public final String homePageHeader = "//td[contains(text(),'Manger Id :')]";
    HomePage homePage;
    LogoutPage logoutPage;


    @Test
    public void loginPageTest() {
        LoginPage loginPage = new LoginPage();
        logoutPage = new LogoutPage();
        loginPage.validateLoginPage(expectedTitle);
//        homePage = new HomePage();
        homePage = loginPage.loginToApplication();
        homePage.validateHomePage(expectedLginedHomePageTitle, homePageHeader);
        logoutPage.logOutFromApp();

    }

}
