package backend.catalogmodule;


import basefunc.BaseClass;
import basefunc.LoginDataForBackEnd;
import dashboard.DashBoardPageForBackEnd;
import dashboard.LoginPageForBackEnd;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class RunTestForSearchTerms extends BaseClass {
    LoginPageForBackEnd loginPageForBackEnd;
    LoginDataForBackEnd loginDataForBackEnd;
    DashBoardPageForBackEnd dashBoardPageForBackEnd;
    SearchTermsPage searchTermsPage;
    @BeforeClass
    public void setUp(){
        loginDataForBackEnd = new LoginDataForBackEnd();
        setUpBrowser(loginDataForBackEnd.getUrlBackend());
        loginPageForBackEnd = new LoginPageForBackEnd(driver);
        loginPageForBackEnd.logIn(loginDataForBackEnd.getUsernameCatalogManager(),
                loginDataForBackEnd.getPassword());
        dashBoardPageForBackEnd = new DashBoardPageForBackEnd(driver);
        searchTermsPage = new SearchTermsPage(driver);
    }
    @Test(enabled = false)
    public void verifyDashboardOpened(){
        Assert.assertTrue(dashBoardPageForBackEnd.verifyCatalogModuleDashboardOpened());
    }
    @Test
    public void addNewSearchTerm(){
        searchTermsPage.addNewSearchTerm();
        Assert.assertTrue(searchTermsPage.verifyAddNewSearchTem());
    }
}
