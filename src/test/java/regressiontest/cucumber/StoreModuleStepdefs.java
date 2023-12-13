package regressiontest.cucumber;

import backend.storemodule.StoreManagerCancelOrder;
import basefunc.BaseClassForBackend;
import basefunc.LoginDataForBackEnd;
import dashboard.DashBoardPageForBackEnd;
import dashboard.LoginPageForBackEnd;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StoreModuleStepdefs extends BaseClassForBackend {
    LoginDataForBackEnd loginDataForBackEnd = new LoginDataForBackEnd();
    LoginPageForBackEnd loginPageForBackEnd = new LoginPageForBackEnd(driver);
    DashBoardPageForBackEnd dashBoardPageForBackEnd = new DashBoardPageForBackEnd(driver);
    StoreManagerCancelOrder storeManagerCancelOrder = new StoreManagerCancelOrder(driver);
    @Given("Store manager on the dashboard page")
    public void storeManagerOnTheDashboardPage() {
        loginPageForBackEnd.logIn(loginDataForBackEnd.getUsernameStoreManager()
                ,loginDataForBackEnd.getPassword());
        dashBoardPageForBackEnd.verifyStoreModuleDashboardOpened();
    }

    @Given("Store manager must be on the dashboard page")
    public void storeManagerMustBeOnTheDashboardPage() {

    }

    @When("Store manager click on the Orders link for cancel order")
    public void storeManagerClickOnTheOrdersLinkForCancelOrder() {
        storeManagerCancelOrder.cancelOrder();
    }

    @Then("Store manager should be able to click on any order")
    public void storeManagerShouldBeAbleToClickOnAnyOrder() {
        storeManagerCancelOrder.verifyCancelled();
    }


}

