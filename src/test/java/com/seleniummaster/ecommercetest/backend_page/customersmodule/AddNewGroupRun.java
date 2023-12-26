package com.seleniummaster.ecommercetest.backend_page.customersmodule;

import com.seleniummaster.ecommercetest.basefunction_page.BaseClass;
import com.seleniummaster.ecommercetest.basefunction_page.LoginDataForBackEnd;
import com.seleniummaster.ecommercetest.dashboard_page.DashBoardPageForBackEnd;
import com.seleniummaster.ecommercetest.dashboard_page.LoginPageForBackEnd;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddNewGroupRun extends BaseClass {
    LoginPageForBackEnd loginPageForBackEnd;
    LoginDataForBackEnd loginDataForBackEnd;
    DashBoardPageForBackEnd dashBoardPageForBackEnd;
    CustomerManagerAddNewCustomerGroup customerManagerAddNewCustomerGroup;
    @BeforeClass
    public void setUpBrowser(){
        loginDataForBackEnd = new LoginDataForBackEnd();
        setUpBrowser(loginDataForBackEnd.getUrlBackend());
        loginPageForBackEnd = new LoginPageForBackEnd(driver);
        dashBoardPageForBackEnd = new DashBoardPageForBackEnd(driver);
        customerManagerAddNewCustomerGroup = new CustomerManagerAddNewCustomerGroup(driver);
    }
    @Test(priority = 2)
    public void goToCustomerManage(){
        dashBoardPageForBackEnd.goToManageCustomersPage2();
    }

    @Test(priority = 1)
    public void loginToCustomerPageBackend(){
        loginPageForBackEnd.logIn(loginDataForBackEnd.getUsernameCustomerManager(),
                loginDataForBackEnd.getPassword());
    }
    @Test(priority = 3)
    public void addCustomerGroup(){
        customerManagerAddNewCustomerGroup = new CustomerManagerAddNewCustomerGroup(driver);
        customerManagerAddNewCustomerGroup.addNewCustomerGroup();
        Assert.assertTrue(customerManagerAddNewCustomerGroup.verifyAddedNewCustomerGroup());

    }
    @Test(priority = 4)
    public void tearDown(){
        closeBrowser();
    }



}
