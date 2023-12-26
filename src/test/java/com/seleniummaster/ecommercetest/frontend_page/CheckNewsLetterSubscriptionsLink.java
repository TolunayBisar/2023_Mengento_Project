package com.seleniummaster.ecommercetest.frontend_page;

import com.seleniummaster.ecommercetest.basefunction_page.BaseClass;
import com.seleniummaster.ecommercetest.basefunction_page.FunctionLibrary;
import com.seleniummaster.ecommercetest.basefunction_page.LoginDataForFrontEnd;
import com.seleniummaster.ecommercetest.dashboard_page.DashBoardPageForFrontEnd;
import com.seleniummaster.ecommercetest.dashboard_page.LoginPageForFrontEnd;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


 public class CheckNewsLetterSubscriptionsLink extends BaseClass {
     LoginPageForFrontEnd loginPageForFrontEnd;
     FunctionLibrary functionLibrary;
     LoginDataForFrontEnd loginDataForFrontEnd;

     DashBoardPageForFrontEnd dashBoardPageForFrontEnd;
     NewsLetterSubLink newsLink;


     @BeforeClass
    public void setUp(){
         loginDataForFrontEnd = new LoginDataForFrontEnd();
         setUpBrowser(loginDataForFrontEnd.getUrlFrontEnd());
         loginPageForFrontEnd=new LoginPageForFrontEnd(driver);
         dashBoardPageForFrontEnd=new DashBoardPageForFrontEnd(driver);
         newsLink=new NewsLetterSubLink(driver);

     }
     @Test(priority = 1)
     public void login(){
         loginPageForFrontEnd.logIn(loginDataForFrontEnd.getUsernameForLogin(),
                 loginDataForFrontEnd.getRegisterPassword());
     }
     @Test(priority = 2)
     public void verifyDashboardOpened(){
        //Assert.assertTrue(newsLink.verifyLoginSuccess());
          Assert.assertTrue(dashBoardPageForFrontEnd.verifyDashboardOpened());
     }
     @Test(priority = 3)
    public void setNewsLetterSubLink(){
         dashBoardPageForFrontEnd.clickOnNewsletterLink();
         Assert.assertTrue(newsLink.verifyGeneralSubscription());
     }






}
