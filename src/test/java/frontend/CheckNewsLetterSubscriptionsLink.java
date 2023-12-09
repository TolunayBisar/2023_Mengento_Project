package frontend;

import basefunc.BaseClass;
import basefunc.FunctionLibrary;
import basefunc.LoginDataForFrontEnd;
import dashboard.DashBoardPageForFrontEnd;
import dashboard.LoginPageForFrontEnd;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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
