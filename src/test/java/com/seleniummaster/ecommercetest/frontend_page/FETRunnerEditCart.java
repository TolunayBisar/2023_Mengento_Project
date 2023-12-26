package com.seleniummaster.ecommercetest.frontend_page;

import com.seleniummaster.ecommercetest.basefunction_page.BaseClass;
import com.seleniummaster.ecommercetest.basefunction_page.LoginDataForFrontEnd;
import com.seleniummaster.ecommercetest.dashboard_page.DashBoardPageForFrontEnd;
import com.seleniummaster.ecommercetest.dashboard_page.LoginPageForFrontEnd;
import org.testng.ITestContext;
import org.testng.annotations.*;

@Listeners(TestResultListener.class)

public class FETRunnerEditCart extends BaseClass {
    //BaseClass baseClass;
    DashBoardPageForFrontEnd dashBoardPage;
    LoginPageForFrontEnd loginPage;
    LoginDataForFrontEnd loginDataForFrontEnd ;
    CustomerInfoPage customerInfoPage;

    @BeforeClass
    public void openBrowser(ITestContext context) {
        //baseClass=new BaseClass();
        loginDataForFrontEnd = new LoginDataForFrontEnd();
        setUpBrowser(loginDataForFrontEnd.getUrlFrontEnd());
        loginPage = new LoginPageForFrontEnd(driver);
        dashBoardPage = new DashBoardPageForFrontEnd(driver);
        customerInfoPage=new CustomerInfoPage(driver);
        context.setAttribute("driver",driver);

    }
    @Test(priority = 1)
    public void Login(){
        loginPage.logIn(loginDataForFrontEnd.getUsernameForLogin(),
                loginDataForFrontEnd.getRegisterPassword());

    }
    @Test(priority = 2)
    public void updateShoppingCart(){
        customerInfoPage.addProductToCard();

        customerInfoPage.setViewShoppingCart();
        customerInfoPage.verifyUpdate();
    }
    @Test(priority = 3)
    public void logUit(){
        customerInfoPage.logUit();

    }
    }


