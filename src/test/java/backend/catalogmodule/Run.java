package backend.catalogmodule;
import basefunc.BaseClass;
import basefunc.BaseClassForBackend;
import dashboard.LoginPageForBackEnd;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * @author : Anar
 * @created : 12/7/2023,6:08 PM
 * @Email : abdanna369@gmail.com
 **/
public class Run extends BaseClass {
    LoginPageForBackEnd loginPageForBackEnd;
    FilterProductsInProductsTab filterProductsInProductsTab;
    @BeforeClass
    public void setUp(){
        setUpBrowser("https://ecommerce.unitedcoderapp.com/index.php/admin");
    }
    @Test(priority = 1)
    public void LoginToCustomerPage(){
        loginPageForBackEnd = new LoginPageForBackEnd(driver);
        loginPageForBackEnd.enterUserName("catalogmanager");
        loginPageForBackEnd.enterPassword("automationadmin!123");
        loginPageForBackEnd.clickLoginButton();
    }
    @Test(priority = 2)
    public void FilterProductsInCatalogPage(){
        filterProductsInProductsTab = new FilterProductsInProductsTab(driver);
    }


}
