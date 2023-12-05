package frontend;

import basefunc.BaseClass;
import basefunc.FunctionLibray;
import basefunc.LoginDataForFrontEnd;
import dashboard.DashBoardPageForFrontEnd;
import dashboard.LoginPageForFrontEnd;
import junit.framework.TestListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.annotations.*;

@Listeners(TestResultListener.class)

public class FETRunnerEditCart  {
    BaseClass baseClass;
    DashBoardPageForFrontEnd dashBoardPage;
    LoginPageForFrontEnd loginPage;
    LoginDataForFrontEnd loginDataForFrontEnd ;
    CustomerInfoPage customerInfoPage;

    @BeforeClass
    public void openBrowser(ITestContext context) {
        baseClass=new BaseClass();
        loginDataForFrontEnd = new LoginDataForFrontEnd();
        baseClass.setUpBrowser(loginDataForFrontEnd.getUrlFrontEnd());
        dashBoardPage = new DashBoardPageForFrontEnd(baseClass.driver);
        loginPage = new LoginPageForFrontEnd(baseClass.driver);
        customerInfoPage=new CustomerInfoPage(baseClass.driver);
        context.setAttribute("driver",baseClass.driver);

    }
    @BeforeMethod
    public void Login(){
        loginPage.logIn(loginDataForFrontEnd.getUsernameForLogin(),
                loginDataForFrontEnd.getRegisterPassword());

    }
    @Test
    public void updateShoppingCart(){

        customerInfoPage.setViewShoppingCart();
        customerInfoPage.verifyUpdate();
    }
    @AfterMethod
    public void logUit(){
        customerInfoPage.logUit();

    }
    @AfterClass
    public void closeBrowser(){
        baseClass.tearDown();
    }
}


