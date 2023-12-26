package com.seleniummaster.ecommercetest.regressiontest.backendtest;

import com.seleniummaster.ecommercetest.backend_page.customersmodule.CustomerManagerAddNewCustomerGroup;
import com.seleniummaster.ecommercetest.basefunction_page.BaseClass;
import com.seleniummaster.ecommercetest.basefunction_page.LoginDataForBackEnd;
import com.seleniummaster.ecommercetest.dashboard_page.DashBoardPageForBackEnd;
import com.seleniummaster.ecommercetest.dashboard_page.LoginPageForBackEnd;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author : tolunaybisar
 * @created : 13.12.2023,13:11
 * @Email :tolunay.bisar@gmail.com
 **/
public class CustomerTestRunner extends BaseClass {

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
        public void navigateToCustomerManagePage(){
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
    @AfterClass
        public void tearDown(){
            closeBrowser();
        }



    }

