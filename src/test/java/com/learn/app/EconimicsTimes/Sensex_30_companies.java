package com.learn.app.EconimicsTimes;

import com.learn.app.Sensex.Pages.Top30SensexListPage;
import com.learn.app.guru99.BaseClass.TestBaseClass;
import org.testng.annotations.Test;

public class Sensex_30_companies extends TestBaseClass {

    public final static String top30SensexPageTitle = "Sensex Today | Live Updates: Sensex share price";
    public final static String listOfTopCompaniesBeforeCompany = "Bajaj Finance Ltd.";

    @Test
    public void bajajFinance() {
        Top30SensexListPage top30SensexListPage = new Top30SensexListPage();

        top30SensexListPage.validateTop30SensexPage();
        top30SensexListPage.validateTtitleOfTop30SensexPage(top30SensexPageTitle);
        top30SensexListPage.getCurrentChangeUpValueOfCompany();
        top30SensexListPage.setListOfCompaniesBeforeCompanyName();


    }


}
