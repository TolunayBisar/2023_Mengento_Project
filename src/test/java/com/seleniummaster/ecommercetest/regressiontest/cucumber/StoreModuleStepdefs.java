package com.seleniummaster.ecommercetest.regressiontest.cucumber;

import com.seleniummaster.ecommercetest.backend_page.storemodule.StoreManagerCancelOrder;
import com.seleniummaster.ecommercetest.basefunction_page.BaseClass;
import com.seleniummaster.ecommercetest.basefunction_page.LoginDataForBackEnd;
import com.seleniummaster.ecommercetest.dashboard_page.DashBoardPageForBackEnd;
import com.seleniummaster.ecommercetest.dashboard_page.LoginPageForBackEnd;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StoreModuleStepdefs extends BaseClass {
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

