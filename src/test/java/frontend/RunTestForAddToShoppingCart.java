package frontend;

import basefunc.BaseClass;
import basefunc.LoginDataForFrontEnd;
import dashboard.DashBoardPageForFrontEnd;
import dashboard.LoginPageForFrontEnd;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class RunTestForAddToShoppingCart extends BaseClass {
    LoginPageForFrontEnd loginPageForFrontEnd;
    LoginDataForFrontEnd loginDataForFrontEnd;
    ProductToShoppingCart productToShoppingCart;

    @BeforeClass
    public void setUp(){
        loginDataForFrontEnd = new LoginDataForFrontEnd();
        setUpBrowser(loginDataForFrontEnd.getUrlFrontEnd());
        loginPageForFrontEnd = new LoginPageForFrontEnd(driver);
        loginPageForFrontEnd.logIn(loginDataForFrontEnd.getUsernameForLogin(),
                loginDataForFrontEnd.getRegisterPassword());
        productToShoppingCart = new ProductToShoppingCart(driver);
    }

    @Test
    public void addToShoppingCart(){
        productToShoppingCart.addProductToShoppingCart01();
        Assert.assertTrue(productToShoppingCart.verifyForShoppingCartPage01());
    }
    @AfterClass
    public void tearDown(){
        productToShoppingCart.logOut();
        closeBrowser();
    }




}
