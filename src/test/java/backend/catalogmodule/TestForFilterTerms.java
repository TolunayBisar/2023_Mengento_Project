package backend.catalogmodule;

import basefunc.ApplicationConfig;
import basefunc.BaseClass;
import basefunc.LoginDataForBackEnd;
import dashboard.LoginPageForBackEnd;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestForFilterTerms extends BaseClass {
    LoginDataForBackEnd loginDataForBackEnd;
    LoginPageForBackEnd loginPageForBackEnd;
    FilterSearchTermsPage filterSearchTermsPage;
    @BeforeClass
    public void setup(){
        setUpBrowser(ApplicationConfig.readFromConfig("config.properties","BackEnd_url"));
        loginDataForBackEnd = new LoginDataForBackEnd();
        loginPageForBackEnd = new LoginPageForBackEnd(driver);
        filterSearchTermsPage = new FilterSearchTermsPage(driver);
        loginPageForBackEnd.logIn(loginDataForBackEnd.getUsernameCatalogManager(), loginDataForBackEnd.getPassword());


    }
    @Test(priority = 1 ,enabled = false)
    public void filterTerms(){
        filterSearchTermsPage.filterBySearchQuery("shirt");
        Assert.assertTrue(filterSearchTermsPage.verifyFilterBySearch("shirt"));
    }
    @Test(priority = 2,enabled = true)
    public void filterByStoreDropdown(){
        filterSearchTermsPage.filterByStore();
        Assert.assertTrue(filterSearchTermsPage.verifyFilter());
    }
    @Test(priority = 3,enabled = false)
    public void filterByResult(){
        filterSearchTermsPage.filterByResult("0","9");
        Assert.assertTrue(filterSearchTermsPage.verifyFilterByResult());
    }
    @Test(priority = 4,enabled = false)
    public void filterByDisplay(){
        filterSearchTermsPage.filterByUse("0","9");
        Assert.assertTrue(filterSearchTermsPage.verifyFilter());

    }
}
