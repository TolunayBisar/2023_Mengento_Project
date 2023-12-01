package frontend;

import basefunc.BaseClass;
import basefunc.LoginDataForFrontEnd;
import dashboard.DashBoardPageForFrontEnd;
import dashboard.LoginPageForFrontEnd;
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
    DashBoardPageForFrontEnd dashBoardPageForFrontEnd ;


    @BeforeClass

    public void getBrowser(){
        loginDataForFrontEnd = new LoginDataForFrontEnd();

        setUpBrowser(loginDataForFrontEnd.getUrlFrontEnd());

        loginPageForFrontEnd = new LoginPageForFrontEnd(driver);

        dashBoardPageForFrontEnd = new DashBoardPageForFrontEnd(driver);

        checkOutOrder  = new CheckOutOrder(driver);


    }


    @Test(priority = 1)
    public void checkOutAsGuest(){
        checkOutOrder.addProductToCartAsGuest();
        checkOutOrder.proceedCheckOutProduct();
        checkOutOrder.checkOutAsGuest();
    }

    @Test(priority = 2)
    public void verifyCheckOutAsGuest(){
        checkOutOrder.verifyCheckOut();
    }

    @Test(priority = 3)
    public void login(){

        loginPageForFrontEnd.logIn(loginDataForFrontEnd.getUsernameForLogin(),
                loginDataForFrontEnd.getRegisterPassword());
    }
    @Test(priority = 4)
    public void checkOut(){
        checkOutOrder.addProductAsRegisteredToCart();
        checkOutOrder.proceedCheckOutProduct();
        checkOutOrder.checkOut();


    }

    @Test(priority = 5)
    public void verifyCheckOut(){
        checkOutOrder.verifyCheckOut();
    }

//    @AfterClass
//    public void tearDown(){
//        closeBrowser();
//    }
//
}
