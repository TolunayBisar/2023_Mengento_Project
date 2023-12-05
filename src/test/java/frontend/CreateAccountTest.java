package frontend;

import basefunc.BaseClass;
import basefunc.FunctionLibrary;
import basefunc.LoginDataForFrontEnd;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author : tolunaybisar
 * @created : 28.11.2023,10:01
 * @Email :tolunay.bisar@gmail.com
 **/
public class CreateAccountTest extends BaseClass{

    LoginDataForFrontEnd loginDataForFrontEnd ;
    FunctionLibrary functionLibrary;
    CreateAnAccountPage accountPage;

    @BeforeClass()
    public void setUp(){
        loginDataForFrontEnd = new LoginDataForFrontEnd();
        ChromeDriverManager.chromedriver().setup();
        setUpBrowser(loginDataForFrontEnd.getUrlFrontEnd());
        accountPage = new CreateAnAccountPage(driver);
        functionLibrary = new FunctionLibrary(driver);
    }
    @Test
    public void createAnAccount(){
        String fileName = "config.properties";
        accountPage.createAnAccountMesut(functionLibrary.generateFakeName1(),functionLibrary.
                generateFakeName1(),functionLibrary.generateFakeName1(),functionLibrary.generateFakeEmail1(),
                functionLibrary.readFromConfigProperties(fileName,"password_frontend1"),functionLibrary.
                readFromConfigProperties(fileName,"confirmPassword_frontend1"));
        Assert.assertTrue(accountPage.verifyCreateAccount());
    }
    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
