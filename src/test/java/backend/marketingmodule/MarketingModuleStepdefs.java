package backend.marketingmodule;

import basefunc.BaseClassForBackend;
import basefunc.LoginDataForBackEnd;
import dashboard.DashBoardPageForBackEnd;
import dashboard.LoginPageForBackEnd;
import io.cucumber.java.en.Given;

public class MarketingModuleStepdefs extends BaseClassForBackend {
    LoginDataForBackEnd loginDataForBackEnd = new LoginDataForBackEnd();
    LoginPageForBackEnd loginPageForBackEnd = new LoginPageForBackEnd(driver);
    DashBoardPageForBackEnd dashBoardPageForBackEnd = new DashBoardPageForBackEnd(driver);
    @Given("Marketing manager on the dashboard page")
    public void marketingManagerOnTheDashboardPage() {
        loginPageForBackEnd.logIn(loginDataForBackEnd.getUsernameMarketingManager()
                ,loginDataForBackEnd.getPassword());
        dashBoardPageForBackEnd.verifyMarketingModuleDashboardOpened();

    }
}
