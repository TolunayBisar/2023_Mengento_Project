package frontend;

import basefunc.BaseClass;
import basefunc.FunctionLibray;
import basefunc.LoginDataForFrontEnd;
import dashboard.DashBoardPageForFrontEnd;
import dashboard.LoginPageForFrontEnd;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


 public class CheckNewsLetterSubscriptionsLink extends BaseClass {
     LoginPageForFrontEnd loginPageForFrontEnd;
     FunctionLibray functionLibray;
     LoginDataForFrontEnd loginDataForFrontEnd;

     DashBoardPageForFrontEnd dashBoardPageForFrontEnd;
     NewsLetterSubLink newsLink;


     @BeforeClass
    public void setUp(){
        /*setUpBrowser(readFromConfig("config.properties","FrontEnd_url"));
         loginPageForFrontEnd=new LoginPageForFrontEnd(driver);
         loginPageForFrontEnd.logIn(readFromConfig("config.properties","username_frontend2"),
                 readFromConfig("config.properties","password_frontend2"));
         dashBoardPageForFrontEnd=new DashBoardPageForFrontEnd(driver);
         newsLink=new NewsLetterSubLink(driver);*/


         loginDataForFrontEnd = new LoginDataForFrontEnd();
         setUpBrowser(loginDataForFrontEnd.getUrlFrontEnd());
         loginPageForFrontEnd=new LoginPageForFrontEnd(driver);
         loginPageForFrontEnd.logIn(loginDataForFrontEnd.getUsernameForLogin(),
                 loginDataForFrontEnd.getRegisterPassword());

         dashBoardPageForFrontEnd=new DashBoardPageForFrontEnd(driver);
         newsLink=new NewsLetterSubLink(driver);

     }
     @Test(priority = 1)
     public void verifyDashboardOpened(){
        //Assert.assertTrue(newsLink.verifyLoginSuccess());
          Assert.assertTrue(dashBoardPageForFrontEnd.verifyDashboardOpened());
     }
     @Test(priority = 2)
    public void setNewsLetterSubLink(){
         dashBoardPageForFrontEnd.clickOnNewsletterLink();
         Assert.assertTrue(newsLink.verifyGeneralSubscription());
     }
     @AfterClass
    public void tearDown(){
         closeBrowser();
     }





}
