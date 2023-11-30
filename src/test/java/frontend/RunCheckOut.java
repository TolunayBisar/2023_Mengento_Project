package frontend;

import basefunc.BaseClass;
import basefunc.FunctionLibray;
import basefunc.LoginDataForFrontEnd;
import dashboard.LoginPageForFrontEnd;
import org.apache.maven.plugin.surefire.runorder.Priority;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author : tolunaybisar
 * @created : 30.11.2023,18:37
 * @Email :tolunay.bisar@gmail.com
 **/
public class RunCheckOut extends BaseClass {
    LoginDataForFrontEnd loginDataForFrontEnd ;
    LoginPageForFrontEnd loginPageForFrontEnd;
    CheckOutOrder checkOutOrder;


    @BeforeClass

    public void getBrowser(){
        loginDataForFrontEnd = new LoginDataForFrontEnd();

        setUpBrowser(loginDataForFrontEnd.getUrlFrontEnd());

        loginPageForFrontEnd = new LoginPageForFrontEnd(driver);
        checkOutOrder  = new CheckOutOrder(driver);


    }

    @Test(priority = 1)
    public void login(){

        loginPageForFrontEnd.logIn(loginDataForFrontEnd.getUsernameForLogin(),
                loginDataForFrontEnd.getRegisterPassword());
    }
    @Test(priority = 2)
    public void checkOut(){
        checkOutOrder.addProductToCart();
        checkOutOrder.proceedCheckOutProduct();
        checkOutOrder.checkOut();


    }

    @Test
    public void verifyCheckOut(){
        checkOutOrder.verifyCheckOut();
    }

    @AfterClass
    public void tearDown(){
        closeBrowser();
    }

}
