package frontend;

import basefunc.ApplicationConfig;
import basefunc.BaseClass;
import basefunc.FunctionLibray;
import basefunc.LoginDataForFrontEnd;
import dashboard.DashBoardPageForFrontEnd;
import dashboard.LoginPageForFrontEnd;
import org.junit.jupiter.api.TestInstance;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Listeners(ApplicationConfig.TestResultListener.class)
public class BigRunnerFrontEnd extends BaseClass {
    LoginPageForFrontEnd loginPageForFrontEnd;
    LoginDataForFrontEnd loginDataForFrontEnd=new LoginDataForFrontEnd();
    DashBoardPageForFrontEnd dashBoardPageForFrontEnd;
    ProductToShoppingCart productToShoppingCart;
    UpdateAndViewAddress updateAndViewAddress;
    ViewMyProductReviewsPage viewMyProductReviewsPage;
    @BeforeClass
    public void setUp(){
        setUpBrowser(loginDataForFrontEnd.getUrlFrontEnd());
        loginPageForFrontEnd=new LoginPageForFrontEnd(driver);
        dashBoardPageForFrontEnd=new DashBoardPageForFrontEnd(driver);
        productToShoppingCart=new ProductToShoppingCart(driver);
        updateAndViewAddress=new UpdateAndViewAddress(driver);
        viewMyProductReviewsPage = new ViewMyProductReviewsPage(driver);
    }
    @Test(priority = 1)
    public void login(){
        loginPageForFrontEnd.userLogin(loginDataForFrontEnd.getUsernameForLogin(),loginDataForFrontEnd.getRegisterPassword());
        Assert.assertTrue(dashBoardPageForFrontEnd.verifyMyDashboardPageOpened());
    }
    @Test(priority = 2)
    public void addToShoppingCart(){
        productToShoppingCart.addProductToShoppingCart01();
        Assert.assertTrue(productToShoppingCart.verifyForShoppingCartPage01());
        productToShoppingCart.addProductsToShoppingCart02();
        Assert.assertTrue(productToShoppingCart.verifyForShoppingCartPage02());
        productToShoppingCart.addProductsToShoppingCart03();
        Assert.assertTrue(productToShoppingCart.verifyForShoppingCartPage03());
        productToShoppingCart.addProductsToShoppingCart04();
        Assert.assertTrue(productToShoppingCart.verifyForShoppingCartPage04());

    }
    @Test(priority = 3)
    public void viewAndUpdateAddressBook(){
        dashBoardPageForFrontEnd.clickAddressBookLink();
        Assert.assertTrue(updateAndViewAddress.viewAddressBookMethod());
        updateAndViewAddress.editBillingAddressMethod();
        Assert.assertTrue(updateAndViewAddress.verifyEditedBillingAddress());
        updateAndViewAddress.editShippingAddressMethod();
        Assert.assertTrue(updateAndViewAddress.verifyEditedShippingAddress());
    }
    @Test(priority = 4)
    public void reviews(){
        viewMyProductReviewsPage.myProductsReviewLinkAndViewDetails();
        viewMyProductReviewsPage.myProductReviewDetails();
        Assert.assertTrue(viewMyProductReviewsPage.verifyReviewDetails());

    }





}
