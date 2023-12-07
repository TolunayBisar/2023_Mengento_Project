package frontend;

import basefunc.ApplicationConfig;
import basefunc.BaseClass;
import basefunc.LoginDataForFrontEnd;
import com.github.javafaker.Faker;
import dashboard.DashBoardPageForFrontEnd;
import dashboard.LoginPageForFrontEnd;
import org.apache.commons.lang3.SystemUtils;
import org.junit.jupiter.api.TestInstance;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Listeners(ApplicationConfig.TestResultListener.class)

public class BigRunnerTest extends BaseClass {
    LoginPageForFrontEnd loginPageForFrontEnd;
    LoginDataForFrontEnd loginDataForFrontEnd=new LoginDataForFrontEnd();
    CreateAccount createAccount;
    EditAccountInfoPage editAccountInfoPage;

    DashBoardPageForFrontEnd dashBoardPageForFrontEnd;
    ProductToShoppingCart productToShoppingCart;
    UpdateAndViewAddress updateAndViewAddress;
    ViewMyProductReviewsPage viewMyProductReviewsPage;
    @BeforeClass
    public void setUp(){
        setUpBrowser(loginDataForFrontEnd.getUrlFrontEnd());
        createAccount = new CreateAccount(driver);
        loginPageForFrontEnd=new LoginPageForFrontEnd(driver);
        dashBoardPageForFrontEnd=new DashBoardPageForFrontEnd(driver);
        productToShoppingCart=new ProductToShoppingCart(driver);
        updateAndViewAddress=new UpdateAndViewAddress(driver);
        viewMyProductReviewsPage = new ViewMyProductReviewsPage(driver);
    }

    @Test(priority = 1)
    public void createAccount(){
        createAccount.creatAccount(Faker.instance().name().firstName(),Faker.instance().name().lastName(),
                Faker.instance().internet().emailAddress(),Faker.instance().internet().password() );
createAccount.verifyEditSuccessfully();

    }

    @Test(priority = 2)
    public void editAccountInfo (){
        dashBoardPageForFrontEnd.clickOnAccountInformationLink();
        editAccountInfoPage.editAccountInfo(Faker.instance().name().firstName(),
                Faker.instance().name().name(),Faker.instance().name().lastName(),
                Faker.instance().internet().emailAddress(),Faker.instance().internet().password());
        editAccountInfoPage.verifyEditSuccessfully();
        dashBoardPageForFrontEnd.logOut();



    }
    @Test(priority = 3)
    public void login(){
        loginPageForFrontEnd.logIn(loginDataForFrontEnd.getUsernameForLogin(),loginDataForFrontEnd.getRegisterPassword());
        Assert.assertTrue(dashBoardPageForFrontEnd.verifyMyDashboardPageOpened());
    }



    @Test(priority = 5)
    public void viewAndUpdateAddressBook(){
        dashBoardPageForFrontEnd.clickAddressBookLink();
        Assert.assertTrue(updateAndViewAddress.viewAddressBookMethod());
        updateAndViewAddress.editBillingAddressMethod();
        Assert.assertTrue(updateAndViewAddress.verifyEditedBillingAddress());
        updateAndViewAddress.editShippingAddressMethod();
        Assert.assertTrue(updateAndViewAddress.verifyEditedShippingAddress());
    }
    @Test(priority = 6)
    public void reviews(){
        viewMyProductReviewsPage.myProductsReviewLinkAndViewDetails();
        viewMyProductReviewsPage.myProductReviewDetails();
        Assert.assertTrue(viewMyProductReviewsPage.verifyReviewDetails());

    }

    @Test(priority = 4)
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
    @AfterClass
    public void tearDown(){
        dashBoardPageForFrontEnd.logOut();
        closeBrowser();
    }
}
