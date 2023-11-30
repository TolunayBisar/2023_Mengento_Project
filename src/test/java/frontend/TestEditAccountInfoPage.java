package frontend;

import basefunc.ApplicationConfig;
import basefunc.BaseClass;
import basefunc.FunctionLibray;
import basefunc.LoginDataForFrontEnd;
import dashboard.DashBoardPageForFrontEnd;
import dashboard.LoginPageForFrontEnd;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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

        createAccount.creatAccount(FunctionLibray.generateFakeName(),FunctionLibray.generateFakeName(),FunctionLibray.generateFakeEmail(),ApplicationConfig.readFromConfig("config.properties","password_edit"));
        Assert.assertTrue(createAccount.verifyEditSuccessfully());

    }
    @Test(priority = 2)
    public void editInfo(){
        dashBoardPageForFrontEnd.clickOnAccountInformationLink();
        editAccountInfoPage.editAccountInfo(FunctionLibray.generateFakeName(),FunctionLibray.generateFakeName(),
                FunctionLibray.generateFakeName(),FunctionLibray.generateFakeEmail()
                ,ApplicationConfig.readFromConfig("config.properties","password_edit"));
        Assert.assertTrue(editAccountInfoPage.verifyEditSuccessfully());

    }


}
