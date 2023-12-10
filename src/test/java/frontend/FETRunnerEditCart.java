package frontend;

import basefunc.BaseClass;
import basefunc.LoginDataForFrontEnd;
import dashboard.DashBoardPageForFrontEnd;
import dashboard.LoginPageForFrontEnd;
import junit.framework.TestListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
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

        customerInfoPage.setViewShoppingCart();
        customerInfoPage.verifyUpdate();
    }
    @Test(priority = 3)
    public void logUit(){
        customerInfoPage.logUit();

    }
    }


