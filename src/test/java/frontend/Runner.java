package frontend;

import basefunc.ApplicationConfig;
import basefunc.BaseClass;
import basefunc.FunctionLibray;
import basefunc.LoginDataForFrontEnd;
import dashboard.DashBoardPageForFrontEnd;
import dashboard.LoginPageForFrontEnd;
import org.junit.jupiter.api.TestInstance;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Listeners(ApplicationConfig.TestResultListener.class)

public class Runner extends BaseClass {
    LoginPageForFrontEnd loginPageForFrontEnd;
    LoginDataForFrontEnd loginDataForFrontEnd;
    UpdateAndViewAddress updateAndViewAddress;
    DashBoardPageForFrontEnd dashBoardPageForFrontEnd;
    @BeforeClass
    public void setUp(){
        loginDataForFrontEnd=new LoginDataForFrontEnd();
        setUpBrowser(loginDataForFrontEnd.getUrlFrontEnd());
        loginPageForFrontEnd=new LoginPageForFrontEnd(driver);
        updateAndViewAddress=new UpdateAndViewAddress(driver);
        dashBoardPageForFrontEnd=new DashBoardPageForFrontEnd(driver);



    }
    @Test(priority = 1)
    public void login(){
        loginPageForFrontEnd.logIn(loginDataForFrontEnd.getUsernameForLogin(),loginDataForFrontEnd.getRegisterPassword());
        dashBoardPageForFrontEnd.verifyMyDashboardPageOpened();
    }
    @Test(priority = 2)
    public void viewAddressBookTest(){
        dashBoardPageForFrontEnd.clickAddressBookLink();
        Assert.assertTrue(updateAndViewAddress.viewAddressBookMethod());
        updateAndViewAddress.editBillingAddressMethod();
        Assert.assertTrue(updateAndViewAddress.verifyEditedBillingAddress());
        updateAndViewAddress.editShippingAddressMethod();
        Assert.assertTrue(updateAndViewAddress.verifyEditedShippingAddress());
        }
    @Test(priority = 3)
    public void updateBillingAddressTest(){
        updateAndViewAddress.editBillingAddressMethod();
        Assert.assertTrue(updateAndViewAddress.verifyEditedBillingAddress());
    }
    @Test(priority = 4)
    public void updateShippingAddressTest(){
        updateAndViewAddress.editShippingAddressMethod();
        Assert.assertTrue(updateAndViewAddress.verifyEditedShippingAddress());
    }
    @AfterClass
    public void close(){
        closeBrowser();
    }
}
