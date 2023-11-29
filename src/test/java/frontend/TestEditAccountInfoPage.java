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

        if (EditDataHolder.getEmail()==null){
            while (loopFlag){
                loginPageForFrontEnd.logIn(EditDataHolder.getUserName(),EditDataHolder.getPassword());
                //Assert.assertTrue(loginPageForFrontEnd.verifyMengentoFrontEndOpen());
                loopFlag = false;


            }

        }


        while (loopFlag){
            loginPageForFrontEnd.logIn(EditDataHolder.getEmail(),EditDataHolder.getPassword());
            loopFlag = false;
        }





    }
    @Test(priority = 2)
    public void editInfo(){
        EditDataHolder.setEmail(FunctionLibray.generateFakeEmail());
        dashBoardPageForFrontEnd.clickOnAccountInformationLink();
        editAccountInfoPage.editAccountInfo(FunctionLibray.generateFakeName(),FunctionLibray.generateFakeName(),
                FunctionLibray.generateFakeName(),EditDataHolder.getEmail()
                ,ApplicationConfig.readFromConfig("config.properties","password_edit"));
        System.out.println(EditDataHolder.getEmail());
        Assert.assertTrue(editAccountInfoPage.verifyEditSuccessfully());

    }


}
