package com.seleniummaster.ecommercetest.frontend_page;

import com.seleniummaster.ecommercetest.basefunction_page.ApplicationConfig;
import com.seleniummaster.ecommercetest.basefunction_page.BaseClass;
import com.seleniummaster.ecommercetest.basefunction_page.LoginDataForFrontEnd;
import com.seleniummaster.ecommercetest.dashboard_page.DashBoardPageForFrontEnd;
import com.seleniummaster.ecommercetest.dashboard_page.LoginPageForFrontEnd;
import org.junit.jupiter.api.TestInstance;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * @author : Anargul
 * @created : 11/29/2023,1:13 PM
 * @Email : abdanna369@gmail.com
 **/
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Listeners(ApplicationConfig.TestResultListener.class)

public class RunnerForFrontEnd extends BaseClass {
    LoginDataForFrontEnd loginDataForFrontEnd;
    LoginPageForFrontEnd loginPageForFrontEnd;
    DashBoardPageForFrontEnd dashBoardPageForFrontEnd;
    ViewOrderAsRegistredUser viewOrderAsRegistredUser;
    ViewOrderAsGuest viewOrderAsGuest;
    RegistredUserViewDownloadbleOrder registredUserViewDownloadbleOrder;

    @BeforeClass
    public void setUp() {
        loginDataForFrontEnd = new LoginDataForFrontEnd();
        setUpBrowser(loginDataForFrontEnd.getUrlFrontEnd());
        loginPageForFrontEnd = new LoginPageForFrontEnd(driver);
        loginPageForFrontEnd = new LoginPageForFrontEnd(driver);
        dashBoardPageForFrontEnd = new DashBoardPageForFrontEnd(driver);
    }

    @Test(priority = 1)
    public void login() {
        loginPageForFrontEnd.logIn(loginDataForFrontEnd.getUsernameForLogin(),
                loginDataForFrontEnd.getRegisterPassword());
    }

    @Test(priority = 2)
    public void RegisterUserViewOrder() {

        viewOrderAsRegistredUser = new ViewOrderAsRegistredUser(driver);
        Assert.assertTrue(viewOrderAsRegistredUser.registredUserViewOrder());

    }
    @Test(priority = 3)
    public void RegisterUserViewDownloadOrder(){
        registredUserViewDownloadbleOrder = new RegistredUserViewDownloadbleOrder(driver);
        Assert.assertTrue(registredUserViewDownloadbleOrder.veriFayeDownloadOrder());
         closeBrowser();
    }

    @Test(priority = 4)
    public void AddProduct() {
        setUpBrowser(loginDataForFrontEnd.getUrlFrontEnd());
        viewOrderAsGuest = new ViewOrderAsGuest(driver);
        viewOrderAsGuest.selectProduct();
        viewOrderAsGuest.selectAColor();
        viewOrderAsGuest.selectASize();
        viewOrderAsGuest.enterQuantity();
        viewOrderAsGuest.clickOnAddToCart();
    }

    @Test(priority = 5)
    public void GuestViewOrder() {
        viewOrderAsGuest = new ViewOrderAsGuest(driver);
        viewOrderAsGuest.userViewOrder();
        Assert.assertTrue(viewOrderAsGuest.verifyRecentlyAddedItems());
    }

    @AfterClass()
    public void tearDown() {
        closeBrowser();
    }

}
