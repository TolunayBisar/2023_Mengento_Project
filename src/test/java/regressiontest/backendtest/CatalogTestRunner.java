package regressiontest.backendtest;


import basefunc.BaseClass;
import basefunc.LoginDataForBackEnd;
import dashboard.DashBoardPageForBackEnd;
import dashboard.LoginPageForBackEnd;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author : tolunaybisar
 * @created : 13.12.2023,13:12
 * @Email :tolunay.bisar@gmail.com
 **/
public class CatalogTestRunner extends BaseClass {
    LoginPageForBackEnd loginPageForBackEnd;
    LoginDataForBackEnd loginDataForBackEnd;
    DashBoardPageForBackEnd dashBoardPageForBackEnd;

    @BeforeClass
    public void setUpBrowser(){
        loginDataForBackEnd = new LoginDataForBackEnd();
        setUpBrowser(loginDataForBackEnd.getUrlBackend());
        loginPageForBackEnd = new LoginPageForBackEnd(driver);
        dashBoardPageForBackEnd = new DashBoardPageForBackEnd(driver);

    }
    @Test(priority = 1)
    public void loginToCatalogPageBackend(){
        loginPageForBackEnd.logIn(loginDataForBackEnd.getUsernameCatalogManager(),
                loginDataForBackEnd.getPassword());
    }





    @AfterClass
    public void tearDown(){
        closeBrowser();
    }



}
