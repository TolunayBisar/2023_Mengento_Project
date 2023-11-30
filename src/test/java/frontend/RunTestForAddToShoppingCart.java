package frontend;

import basefunc.BaseClass;
import dashboard.DashBoardPageForFrontEnd;
import dashboard.LoginPageForFrontEnd;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static basefunc.ApplicationConfig.readFromConfig;

public class RunTestForAddToShoppingCart extends BaseClass {
    LoginPageForFrontEnd loginPage;
    DashBoardPageForFrontEnd dashBoardPage;
    ProductToShoppingCart productToShoppingCart;
    @BeforeClass
    public void setUp(){
        setUpBrowser(readFromConfig("config.properties","FrontEnd_url"));
        loginPage=new LoginPageForFrontEnd(driver);
        loginPage.logIn(readFromConfig("config.properties","username_frontend2"),
                readFromConfig("config.properties","password_frontend2"));
        dashBoardPage=new DashBoardPageForFrontEnd(driver);
        productToShoppingCart = new ProductToShoppingCart(driver);
    }
    @Test
    public void addToShoppingCart(){
        productToShoppingCart.addProductToShoppingCart();
        Assert.assertTrue(productToShoppingCart.verifyForShoppingCartPage());


    }
    @AfterClass
    public void tearDown(){
        productToShoppingCart.logOut();
        closeBrowser();
    }




}
