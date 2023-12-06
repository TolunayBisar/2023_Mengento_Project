package backend.customersmodule;

import basefunc.BaseClass;
import basefunc.LoginDataForBackEnd;
import dashboard.DashBoardPageForBackEnd;
import dashboard.LoginPageForBackEnd;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RunTestFilterCustomersGroup extends BaseClass {
    LoginPageForBackEnd loginPageForBackEnd;
    LoginDataForBackEnd loginDataForBackEnd;
    DashBoardPageForBackEnd dashBoardPageForBackEnd;
    FilterCustomerGroupPage filterCustomerGroupPage;
    @BeforeClass
    public void setUp(){
        loginDataForBackEnd = new LoginDataForBackEnd();
        setUpBrowser(loginDataForBackEnd.getUrlBackend());
        loginPageForBackEnd = new LoginPageForBackEnd(driver);
        loginPageForBackEnd.logIn(loginDataForBackEnd.getUsernameCustomerManager(),
                loginDataForBackEnd.getPassword());
        dashBoardPageForBackEnd = new DashBoardPageForBackEnd(driver);
        filterCustomerGroupPage = new FilterCustomerGroupPage(driver);
    }
    @Test
    public void verifyDashboardOpened(){
        Assert.assertTrue(dashBoardPageForBackEnd.verifyCustomerModuleDashboardPage());
    }
    @Test
    public void filterGroup(){
        dashBoardPageForBackEnd.goToManageCustomersPage();
        filterCustomerGroupPage.filterCustomersGroup();
        Assert.assertTrue(filterCustomerGroupPage.verifyFilterCustomersGroup());
    }
    @AfterClass
    public void tearDown(){
        filterCustomerGroupPage.logOut();
        closeBrowser();
    }
}
