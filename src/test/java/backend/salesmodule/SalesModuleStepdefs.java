package backend.salesmodule;

import basefunc.BaseClassForBackend;
import basefunc.LoginDataForBackEnd;
import dashboard.DashBoardPageForBackEnd;
import dashboard.LoginPageForBackEnd;
import io.cucumber.java.en.Given;

public class SalesModuleStepdefs extends BaseClassForBackend {
    LoginDataForBackEnd loginDataForBackEnd = new LoginDataForBackEnd();
    LoginPageForBackEnd loginPageForBackEnd = new LoginPageForBackEnd(driver);
    DashBoardPageForBackEnd dashBoardPageForBackEnd = new DashBoardPageForBackEnd(driver);
    @Given("Sales manager on the dashboard page")
    public void salesManagerOnTheDashboardPage() {
        loginPageForBackEnd.logIn(loginDataForBackEnd.getUsernameSalesManager()
                ,loginDataForBackEnd.getPassword());
        dashBoardPageForBackEnd.verifySalesModuleDashboardOpened();

    }
}
