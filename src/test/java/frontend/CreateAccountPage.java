package frontend;

import basefunc.BaseClass;
import basefunc.FunctionLibrary;
import dashboard.DashBoardPageForFrontEnd;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author : tolunaybisar
 * @created : 28.11.2023,10:01
 * @Email :tolunay.bisar@gmail.com
 **/
public class CreateAccountPage extends BaseClass{

    BaseClass baseClass;
    FunctionLibrary functionLibrary;
    DashBoardPageForFrontEnd dashboardPage;

    @BeforeClass()
    public void setUp(){
        openBrowser();
        baseClass = new BaseClass();
        functionLibrary = new FunctionLibrary(driver);
        dashboardPage = new DashBoardPageForFrontEnd(driver);
    }
    @Test
    public void createAnAccount(){
        String fileName = "config.properties";
        dashboardPage.createAnAccountMesut(functionLibrary.generateFakeName(),functionLibrary.
                generateFakeName(),functionLibrary.generateFakeName(),functionLibrary.
                readFromConfigProperties(fileName,"username_frontend1"),functionLibrary.
                readFromConfigProperties(fileName,"password_frontend1"),functionLibrary.
                readFromConfigProperties(fileName,"confirmPassword_frontend1"));
    }
    @AfterClass
    public void tearDown(){
        //baseClass.closeBrowser();
    }

}
