package com.seleniummaster.ecommercetest.frontend_page;

import com.seleniummaster.ecommercetest.basefunction_page.ApplicationConfig;
import com.seleniummaster.ecommercetest.basefunction_page.BaseClass;
import com.seleniummaster.ecommercetest.basefunction_page.FunctionLibrary;
import com.seleniummaster.ecommercetest.basefunction_page.LoginDataForFrontEnd;
import com.seleniummaster.ecommercetest.dashboard_page.DashBoardPageForFrontEnd;
import com.seleniummaster.ecommercetest.dashboard_page.LoginPageForFrontEnd;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestEditAccountInfoPage extends BaseClass {
    LoginDataForFrontEnd loginDataForFrontEnd;
    DashBoardPageForFrontEnd dashBoardPageForFrontEnd;
    LoginPageForFrontEnd loginPageForFrontEnd;
    EditAccountInfoPage editAccountInfoPage;
    CreateAccount createAccount;
    ApplicationConfig applicationConfig;
    @BeforeClass
    public void setup(){

        setUpBrowser(ApplicationConfig.readFromConfig("config.properties","FrontEnd_url"));
        loginDataForFrontEnd = new LoginDataForFrontEnd();
        dashBoardPageForFrontEnd = new DashBoardPageForFrontEnd(driver);
        loginPageForFrontEnd = new LoginPageForFrontEnd(driver);
        editAccountInfoPage = new EditAccountInfoPage(driver);
        createAccount = new CreateAccount(driver);

        }

    @Test(priority = 1)
    public void createAccount(){

        createAccount.creatAccount(FunctionLibrary.generateFakeName(),FunctionLibrary.generateFakeName(),FunctionLibrary.generateFakeEmail(),ApplicationConfig.readFromConfig("config.properties","password_edit"));
        Assert.assertTrue(createAccount.verifyEditSuccessfully());

    }
    @Test(priority = 2)
    public void editInfo(){
        dashBoardPageForFrontEnd.clickOnAccountInformationLink();
        editAccountInfoPage.editAccountInfo(FunctionLibrary.generateFakeName(),FunctionLibrary.generateFakeName(),
                FunctionLibrary.generateFakeName(),FunctionLibrary.generateFakeEmail()
                ,ApplicationConfig.readFromConfig("config.properties","password_edit"));
        Assert.assertTrue(editAccountInfoPage.verifyEditSuccessfully());

    }


}
