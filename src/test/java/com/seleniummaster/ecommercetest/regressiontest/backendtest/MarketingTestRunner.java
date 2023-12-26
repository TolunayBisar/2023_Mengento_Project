package com.seleniummaster.ecommercetest.regressiontest.backendtest;

import com.seleniummaster.ecommercetest.basefunction_page.BaseClass;
import com.seleniummaster.ecommercetest.basefunction_page.LoginDataForBackEnd;
import com.seleniummaster.ecommercetest.dashboard_page.DashBoardPageForBackEnd;
import com.seleniummaster.ecommercetest.dashboard_page.LoginPageForBackEnd;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author : tolunaybisar
 * @created : 13.12.2023,13:12
 * @Email :tolunay.bisar@gmail.com
 **/
public class MarketingTestRunner extends BaseClass {

    LoginPageForBackEnd loginPageForBackEnd;
    LoginDataForBackEnd loginDataForBackEnd;
    DashBoardPageForBackEnd dashBoardPageForBackEnd;

    @BeforeClass
    public void setUpBrowser(){
        loginDataForBackEnd = new LoginDataForBackEnd();
        setUpBrowser(loginDataForBackEnd.getUrlBackend());
        loginPageForBackEnd = new LoginPageForBackEnd(driver);
        dashBoardPageForBackEnd = new DashBoardPageForBackEnd(driver);

    }
    @Test(priority = 1)
    public void loginToMarketingPageBackend(){
        loginPageForBackEnd.logIn(loginDataForBackEnd.getUsernameMarketingManager(),
                loginDataForBackEnd.getPassword());
    }





    @AfterClass
    public void tearDown(){
        closeBrowser();
    }
}
