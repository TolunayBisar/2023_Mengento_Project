package com.seleniummaster.ecommercetest.frontend_page;

import com.seleniummaster.ecommercetest.basefunction_page.BaseClass;
import com.seleniummaster.ecommercetest.basefunction_page.LoginDataForFrontEnd;
import com.seleniummaster.ecommercetest.dashboard_page.DashBoardPageForFrontEnd;
import com.seleniummaster.ecommercetest.dashboard_page.LoginPageForFrontEnd;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author : tolunaybisar
 * @created : 30.11.2023,18:37
 * @Email :tolunay.bisar@gmail.com
 **/
public class RunCheckOut extends BaseClass {
    LoginDataForFrontEnd loginDataForFrontEnd ;
    LoginPageForFrontEnd loginPageForFrontEnd;
    CheckOutOrder checkOutOrder;
    DashBoardPageForFrontEnd dashBoardPageForFrontEnd ;


    @BeforeClass

    public void getBrowser(){
        loginDataForFrontEnd = new LoginDataForFrontEnd();

        setUpBrowser(loginDataForFrontEnd.getUrlFrontEnd());

        loginPageForFrontEnd = new LoginPageForFrontEnd(driver);

        dashBoardPageForFrontEnd = new DashBoardPageForFrontEnd(driver);

        checkOutOrder  = new CheckOutOrder(driver);


    }


    @Test(priority = 4,enabled = true)
    public void checkOutAsGuest(){
        setUpBrowser(loginDataForFrontEnd.getUrlFrontEnd());
        checkOutOrder = new CheckOutOrder(driver);
        checkOutOrder.addProductToCartAsGuest();
        checkOutOrder.proceedCheckOutProduct();
        checkOutOrder.checkOutAsGuest();
        checkOutOrder.fillBillInfo();
        checkOutOrder.continueCheckoutAsGuest();
    }

    @Test(priority = 6,enabled = true)
    public void verifyCheckOutAsGuest(){
        checkOutOrder.verifyCheckOut();
    }

    @Test(priority = 1)
    public void login(){

        loginPageForFrontEnd.logIn(loginDataForFrontEnd.getUsernameForLogin(),
                loginDataForFrontEnd.getRegisterPassword());
        Assert.assertTrue(dashBoardPageForFrontEnd.verifyDashboardOpened());
    }

    @Test(priority = 2)
    public void checkOut(){

        checkOutOrder.checkOutAsRegister();


    }

    @Test(priority = 3)
    public void verifyCheckOut(){

        Assert.assertTrue(checkOutOrder.verifyCheckOut());
       driver.close();
    }

    @AfterClass
    public void tearDown(){
        closeBrowser();
    }

}
