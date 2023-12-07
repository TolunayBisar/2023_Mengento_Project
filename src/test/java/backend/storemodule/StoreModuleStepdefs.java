package backend.storemodule;

import basefunc.BaseClassForBackend;
import basefunc.LoginDataForBackEnd;
import dashboard.DashBoardPageForBackEnd;
import dashboard.LoginPageForBackEnd;
import io.cucumber.java.en.Given;

public class StoreModuleStepdefs extends BaseClassForBackend {
    LoginDataForBackEnd loginDataForBackEnd = new LoginDataForBackEnd();
    LoginPageForBackEnd loginPageForBackEnd = new LoginPageForBackEnd(driver);
    DashBoardPageForBackEnd dashBoardPageForBackEnd = new DashBoardPageForBackEnd(driver);
    @Given("Store manager on the dashboard page")
    public void storeManagerOnTheDashboardPage() {
        loginPageForBackEnd.logIn(loginDataForBackEnd.getUsernameStoreManager()
                ,loginDataForBackEnd.getPassword());
        dashBoardPageForBackEnd.verifyStoreModuleDashboardOpened();
    }
}
