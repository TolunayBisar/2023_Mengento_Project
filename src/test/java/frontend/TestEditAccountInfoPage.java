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
    ApplicationConfig applicationConfig;
    @BeforeClass
    public void setup(){

        setUpBrowser(ApplicationConfig.readFromConfig("config.properties","FrontEnd_url"));
        loginDataForFrontEnd = new LoginDataForFrontEnd();
        dashBoardPageForFrontEnd = new DashBoardPageForFrontEnd(driver);
        loginPageForFrontEnd = new LoginPageForFrontEnd(driver);
        editAccountInfoPage = new EditAccountInfoPage(driver);

        }
    @Test(priority = 1)
    public void login(){
        boolean loopFlag=true;
        Object object=null;
        if (object==null){
            while (loopFlag){
                loginPageForFrontEnd.logIn(ApplicationConfig.readFromConfig("config.properties","username_edit"),ApplicationConfig.readFromConfig("config.properties","password_edit"));
                //Assert.assertTrue(loginPageForFrontEnd.verifyMengentoFrontEndOpen());
                loopFlag = false;
                object  = new Object[1];

            }

        }


        while (loopFlag){
            loginPageForFrontEnd.logIn(EditDataHolder.getEmail(),ApplicationConfig.readFromConfig("config.properties","password_edit"));
        }





    }
    @Test(priority = 2,invocationCount = 2)
    public void editInfo(){
        dashBoardPageForFrontEnd.clickOnAccountInformationLink();
        editAccountInfoPage.editAccountInfo(FunctionLibray.generateFakeName(),FunctionLibray.generateFakeName(),
                FunctionLibray.generateFakeName(),EditDataHolder.getEmail()
                ,ApplicationConfig.readFromConfig("config.properties","password_edit"));
        Assert.assertTrue(editAccountInfoPage.verifyEditSuccessfully());

    }


}
