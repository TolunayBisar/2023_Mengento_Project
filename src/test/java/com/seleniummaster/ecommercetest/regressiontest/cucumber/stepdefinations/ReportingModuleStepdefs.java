package com.seleniummaster.ecommercetest.regressiontest.cucumber.stepdefinations;

import com.seleniummaster.ecommercetest.backend_page.reportingmodule.ReportingManagerSeeTotalOrder;
import com.seleniummaster.ecommercetest.basefunction_page.BaseClass;
import com.seleniummaster.ecommercetest.basefunction_page.LoginDataForBackEnd;
import com.seleniummaster.ecommercetest.dashboard_page.DashBoardPageForBackEnd;
import com.seleniummaster.ecommercetest.dashboard_page.LoginPageForBackEnd;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReportingModuleStepdefs extends BaseClass {
    LoginDataForBackEnd loginDataForBackEnd = new LoginDataForBackEnd();
    LoginPageForBackEnd loginPageForBackEnd = new LoginPageForBackEnd(driver);
    DashBoardPageForBackEnd dashBoardPageForBackEnd = new DashBoardPageForBackEnd(driver);
    ReportingManagerSeeTotalOrder reportingManagerSeeTotalOrder = new ReportingManagerSeeTotalOrder(driver);
    @Given("Reporting manager on the dashboard page")
    public void reportingManagerOnTheDashboardPage() {
        loginPageForBackEnd.logIn(loginDataForBackEnd.getUsernameReportingManager()
                ,loginDataForBackEnd.getPassword());
        dashBoardPageForBackEnd.verifyReportModuleDashboardOpened();
    }

    @Given("Reporting manager must be on the dashboard page")
    public void reportingManagerMustBeOnTheDashboardPage() {
    }

    @When("Reporting manager clicks on the total orders link")
    public void reportingManagerClicksOnTheTotalOrdersLink() {
        reportingManagerSeeTotalOrder.seeTotalOrder();
    }

    @Then("Reporting manager able to see the total orders")
    public void reportingManagerAbleToSeeTheTotalOrders() {
        reportingManagerSeeTotalOrder.verifyMessageForTotalOrder();
    }
}
