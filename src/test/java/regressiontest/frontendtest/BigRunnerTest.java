package regressiontest.frontendtest;

import basefunc.ApplicationConfig;
import basefunc.BaseClass;
import basefunc.FunctionLibrary;
import basefunc.LoginDataForFrontEnd;
import com.github.javafaker.Faker;
import dashboard.DashBoardPageForFrontEnd;
import dashboard.LoginPageForFrontEnd;
import frontend.*;
import org.apache.commons.lang3.SystemUtils;
import org.junit.jupiter.api.TestInstance;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.tukaani.xz.check.Check;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Listeners(ApplicationConfig.TestResultListener.class)

public class BigRunnerTest extends BaseClass {
    FunctionLibrary functionLibrary;
    LoginPageForFrontEnd loginPageForFrontEnd;
    LoginDataForFrontEnd loginDataForFrontEnd=new LoginDataForFrontEnd();
    CreateAccount createAccount;
    EditAccountInfoPage editAccountInfoPage;
CustomerInfoPage customerInfoPage;
    DashBoardPageForFrontEnd dashBoardPageForFrontEnd;
    ProductToShoppingCart productToShoppingCart;
    ViewOrderAsRegistredUser viewOrderAsRegistredUser;
    UpdateAndViewAddress updateAndViewAddress;
    ViewMyProductReviewsPage viewMyProductReviewsPage;
    CheckOutOrder checkOutOrder;
    NewsLetterSubLink newsLetterSubLink;
    ViewOrderAsGuest viewOrderAsGuest;
    @BeforeClass
    public void setUp(){
        setUpBrowser(loginDataForFrontEnd.getUrlFrontEnd());
        functionLibrary = new FunctionLibrary(driver);
        createAccount = new CreateAccount(driver);
        loginPageForFrontEnd=new LoginPageForFrontEnd(driver);
        dashBoardPageForFrontEnd=new DashBoardPageForFrontEnd(driver);
        productToShoppingCart=new ProductToShoppingCart(driver);
        customerInfoPage = new CustomerInfoPage(driver);
        viewMyProductReviewsPage = new ViewMyProductReviewsPage(driver);
        updateAndViewAddress=new UpdateAndViewAddress(driver);
        viewMyProductReviewsPage = new ViewMyProductReviewsPage(driver);
        checkOutOrder = new CheckOutOrder(driver);
        newsLetterSubLink = new NewsLetterSubLink(driver);
        viewOrderAsGuest = new ViewOrderAsGuest(driver);
    }

    @Test(priority = 1)
    public void createAccount(){
        createAccount.creatAccount(Faker.instance().name().firstName(),Faker.instance().name().lastName(),
                Faker.instance().internet().emailAddress(),Faker.instance().internet().password() );
createAccount.verifyEditSuccessfully();
        dashBoardPageForFrontEnd.logOut();

    }

    @Test(priority = 2,enabled = false)
    public void editAccountInfo (){
        dashBoardPageForFrontEnd.clickOnAccountInformationLink();
        editAccountInfoPage.editAccountInfo(Faker.instance().name().firstName(),
                Faker.instance().name().name(),Faker.instance().name().lastName(),
                Faker.instance().internet().emailAddress(),Faker.instance().internet().password());
        editAccountInfoPage.verifyEditSuccessfully();
        dashBoardPageForFrontEnd.logOut();




    }

    @Test(priority = 3,enabled = false)
    public void checkoutOrderAsGuest(){
        checkOutOrder = new CheckOutOrder(driver);
        checkOutOrder.addProductToCartAsGuest();
        checkOutOrder.proceedCheckOutProduct();
        checkOutOrder.checkOutAsGuest();
        checkOutOrder.fillBillInfo();
        checkOutOrder.continueCheckoutAsGuest();
    }

    @Test(priority = 4,enabled = false)
    public void viewOrderAsGuest(){
        viewOrderAsGuest = new ViewOrderAsGuest(driver);
        viewOrderAsGuest.selectProduct();
        viewOrderAsGuest.selectAColor();
        viewOrderAsGuest.selectASize();
        viewOrderAsGuest.enterQuantity();
        viewOrderAsGuest.clickOnAddToCart();
        viewOrderAsGuest = new ViewOrderAsGuest(driver);
        viewOrderAsGuest.userViewOrder();
        Assert.assertTrue(viewOrderAsGuest.verifyRecentlyAddedItems());

    }


    @Test(priority = 5)
    public void login(){
        loginPageForFrontEnd.logIn(loginDataForFrontEnd.getUsernameForLogin(),loginDataForFrontEnd.getRegisterPassword());
        Assert.assertTrue(dashBoardPageForFrontEnd.verifyMyDashboardPageOpened());
    }



    @Test(priority = 6)
    public void viewAndUpdateAddressBook(){
        dashBoardPageForFrontEnd.clickAddressBookLink();
        Assert.assertTrue(updateAndViewAddress.viewAddressBookMethod());
        updateAndViewAddress.editBillingAddressMethod();
        Assert.assertTrue(updateAndViewAddress.verifyEditedBillingAddress());
        updateAndViewAddress.editShippingAddressMethod();
        Assert.assertTrue(updateAndViewAddress.verifyEditedShippingAddress());
    }
    @Test(priority = 7)
    public void reviews(){
        viewMyProductReviewsPage.myProductsReviewLinkAndViewDetails();
        viewMyProductReviewsPage.myProductReviewDetails();
        Assert.assertTrue(viewMyProductReviewsPage.verifyReviewDetails());

    }

    @Test(priority = 9)
    public void addToShoppingCart(){
        productToShoppingCart.addProductToShoppingCart01();
        Assert.assertTrue(productToShoppingCart.verifyForShoppingCartPage01());
        //productToShoppingCart.addProductsToShoppingCart02();
        //Assert.assertTrue(productToShoppingCart.verifyForShoppingCartPage02());
        //productToShoppingCart.addProductsToShoppingCart03();
        //Assert.assertTrue(productToShoppingCart.verifyForShoppingCartPage03());
        productToShoppingCart.addProductsToShoppingCart04();
        Assert.assertTrue(productToShoppingCart.verifyForShoppingCartPage04());

    }

    @Test(priority = 10)
    public void updateShoppingCart(){
        customerInfoPage.setViewShoppingCart();
        customerInfoPage.verifyUpdate();


    }




    @Test(priority = 11)
    public void checkoutOrder() {
    checkOutOrder.checkOutAsRegister();
    checkOutOrder.verifyCheckOut();
    }

    @Test(priority = 8)
    public void newsletterSublink() {
        dashBoardPageForFrontEnd.clickOnNewsletterLink();
        Assert.assertTrue(newsLetterSubLink.verifyGeneralSubscription());

    }



        @AfterClass
    public void tearDown(){
        closeBrowser();
    }
}
