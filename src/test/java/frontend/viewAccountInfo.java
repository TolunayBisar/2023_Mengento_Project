package frontend;

import basefunc.ApplicationConfig;
import basefunc.BaseClass;
import basefunc.LoginDataForFrontEnd;
import dashboard.DashBoardPageForFrontEnd;
import dashboard.LoginPageForFrontEnd;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class viewAccountInfo extends BaseClass {
    LoginPageForFrontEnd loginPageForFrontEnd;
    DashBoardPageForFrontEnd dashBoardPageForFrontEnd;
    LoginDataForFrontEnd loginDataForFrontEnd;
    String fileName = "config.properties";

    @BeforeClass
    public void setUp(){
        loginDataForFrontEnd=new LoginDataForFrontEnd();
        setUpBrowser(loginDataForFrontEnd.getUrlFrontEnd());
        loginPageForFrontEnd= new LoginPageForFrontEnd(driver);
        dashBoardPageForFrontEnd = new DashBoardPageForFrontEnd(driver);
    }

    @Test(priority = 1)
    public void setLoginPageForFrontEnd(){
        loginPageForFrontEnd.logIn(loginDataForFrontEnd.getUsernameForLogin(),loginDataForFrontEnd.getRegisterPassword());
        Assert.assertTrue(dashBoardPageForFrontEnd.verifyDashboardOpened());
    }

    @Test(priority = 2)
    public void viewAccountInfoPage(){
        dashBoardPageForFrontEnd.clickOnAccountDashboarLink();
    }
    @Test(priority = 3)
    public void verifyAccountInfoPage(){
        boolean isAccountInfoPageOpened= dashBoardPageForFrontEnd.verifyDashboardOpened();
        Assert.assertTrue(isAccountInfoPageOpened,"Account info page opened");
    }
    @Test(priority = 4)
    public void viewAccountInfoPage2(){
        dashBoardPageForFrontEnd.clickOnAccountInformationLink();


    }
    @Test(priority = 5)
    public void verifyAccountInfoPage2(){
        boolean isAccountInfoPageOpened2= dashBoardPageForFrontEnd.verifyAccountInfo2();
        Assert.assertTrue(isAccountInfoPageOpened2,"editAccountInformation page");

    }







}
