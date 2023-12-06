package frontend;

import basefunc.ApplicationConfig;
import basefunc.BaseClass;
import basefunc.FunctionLibrary;
import basefunc.LoginDataForFrontEnd;
import dashboard.DashBoardPageForFrontEnd;
import dashboard.LoginPageForFrontEnd;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;



public class TestEditAccountInfoPage extends BaseClass {
    LoginDataForFrontEnd loginDataForFrontEnd;
    DashBoardPageForFrontEnd dashBoardPageForFrontEnd;
    LoginPageForFrontEnd loginPageForFrontEnd;
    EditAccountInfoPage editAccountInfoPage;
    CreateAccount createAccount;
    ApplicationConfig applicationConfig;
    @BeforeClass
    public void setup(){

        setUpBrowser(ApplicationConfig.readFromConfig("config.properties","FrontEnd_url"));
        loginDataForFrontEnd = new LoginDataForFrontEnd();
        dashBoardPageForFrontEnd = new DashBoardPageForFrontEnd(driver);
        loginPageForFrontEnd = new LoginPageForFrontEnd(driver);
        editAccountInfoPage = new EditAccountInfoPage(driver);
        createAccount = new CreateAccount(driver);

        }

    @Test(priority = 1)
    public void createAccount(){

        createAccount.creatAccount(FunctionLibrary.generateFakeName(),FunctionLibrary.generateFakeName(),FunctionLibrary.generateFakeEmail(),ApplicationConfig.readFromConfig("config.properties","password_edit"));
        Assert.assertTrue(createAccount.verifyEditSuccessfully());

    }
    @Test(priority = 2)
    public void editInfo(){
        dashBoardPageForFrontEnd.clickOnAccountInformationLink();
        editAccountInfoPage.editAccountInfo(FunctionLibrary.generateFakeName(),FunctionLibrary.generateFakeName(),
                FunctionLibrary.generateFakeName(),FunctionLibrary.generateFakeEmail()
                ,ApplicationConfig.readFromConfig("config.properties","password_edit"));
        Assert.assertTrue(editAccountInfoPage.verifyEditSuccessfully());

    }


}
