package frontend;

import basefunc.BaseClass;

import org.junit.jupiter.api.TestInstance;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * @author : Anargul
 * @created : 11/29/2023,1:13 PM
 * @Email : abdanna369@gmail.com
 **/
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Listeners(TestResultListener.class)

public class RunnerForFrontEnd extends BaseClass {
    ViewOrderAsGuest viewOrderAsGuest ;
    ViewOrderAsRegistredUser viewOrderAsRegistredUser;

    @BeforeClass
    public void setUp(){
        setUpBrowser("https://ecommerce.unitedcoderapp.com");

    }
    @Test(priority = 1)
    public void AddProduct() {
        viewOrderAsGuest = new ViewOrderAsGuest(driver);
        viewOrderAsGuest.selectProduct();
        viewOrderAsGuest.selectAColor();
        viewOrderAsGuest.selectASize();
        viewOrderAsGuest.enterQuantity();
        viewOrderAsGuest.clickOnAddToCart();
    }

    @Test(priority = 2)
    public void GusetViewOrder() {
        viewOrderAsGuest = new ViewOrderAsGuest(driver);
        viewOrderAsGuest.userViewOrder();
        Assert.assertTrue(viewOrderAsGuest.verifyRecentlyAddedItems());

    }
    @Test(priority = 3)
    public void RegisterUserViewOrder(){
        viewOrderAsRegistredUser = new ViewOrderAsRegistredUser(driver);
        viewOrderAsRegistredUser.clickMyAccount();
        viewOrderAsRegistredUser.enterEmail();
        viewOrderAsRegistredUser.enterPass();
        viewOrderAsRegistredUser.clickLogin();
        Assert.assertTrue(viewOrderAsRegistredUser.registredUserViewOrder());
    }

}
