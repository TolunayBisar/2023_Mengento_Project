package backend.customersmodule;

import basefunc.BaseClass;
import basefunc.LoginDataForBackEnd;
import dashboard.DashBoardPageForBackEnd;
import dashboard.LoginPageForBackEnd;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author : Anargul
 * @created : 12/5/2023,9:08 PM
 * @Email : abdanna369@gmail.com
 **/
public class RunForCustomerModule extends BaseClass {
    LoginPageForBackEnd loginPageForBackEnd;
    LoginDataForBackEnd loginDataForBackEnd;
    DashBoardPageForBackEnd dashBoardPageForBackEnd;
    CustomerFilterByEmail customerFilterByEmail;

    @BeforeClass
    public void setUp(){
        setUpBrowser("https://ecommerce.unitedcoderapp.com/index.php/admin");
    }
    @Test(priority = 1)
    public void LoginToCustomerPage(){
        loginPageForBackEnd = new LoginPageForBackEnd(driver);
        loginPageForBackEnd.enterUserName("customermanager");
        loginPageForBackEnd.enterPassword("automationadmin!123");
        loginPageForBackEnd.clickLoginButton();
    }
    @Test(priority = 2)
    public void FilterCustomerEmail(){
        customerFilterByEmail= new CustomerFilterByEmail(driver);
        customerFilterByEmail.filterCustomerByEmail();
        Assert.assertTrue(customerFilterByEmail.verifyNoFoundEmail());
    }
}
