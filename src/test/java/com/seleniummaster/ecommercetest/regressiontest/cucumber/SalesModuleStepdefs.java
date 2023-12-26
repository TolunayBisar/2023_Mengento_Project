package com.seleniummaster.ecommercetest.regressiontest.cucumber;

import com.seleniummaster.ecommercetest.backend_page.salesmodule.SalesManagerViewInvoices;
import com.seleniummaster.ecommercetest.basefunction_page.BaseClass;
import com.seleniummaster.ecommercetest.basefunction_page.LoginDataForBackEnd;
import com.seleniummaster.ecommercetest.dashboard_page.DashBoardPageForBackEnd;
import com.seleniummaster.ecommercetest.dashboard_page.LoginPageForBackEnd;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SalesModuleStepdefs extends BaseClass {
    LoginDataForBackEnd loginDataForBackEnd = new LoginDataForBackEnd();
    LoginPageForBackEnd loginPageForBackEnd = new LoginPageForBackEnd(driver);
    DashBoardPageForBackEnd dashBoardPageForBackEnd = new DashBoardPageForBackEnd(driver);
    SalesManagerViewInvoices salesManagerViewInvoices = new SalesManagerViewInvoices(driver);
    @Given("Sales manager on the dashboard page")
    public void salesManagerOnTheDashboardPage() {
        loginPageForBackEnd.logIn(loginDataForBackEnd.getUsernameSalesManager()
                ,loginDataForBackEnd.getPassword());
        dashBoardPageForBackEnd.verifySalesModuleDashboardOpened();

    }

    @Given(":Sales manager must be on the dash board page")
    public void salesManagerMustBeOnTheDashBoardPage() {
    }

    @When(":Sales manager click on the views link for invoices")
    public void salesManagerClickOnTheViewsLinkForInvoices() {
        salesManagerViewInvoices.viewInvoiceAndComment();

    }

    @Then(":Sales manager should be able to see all invoices")
    public void salesManagerShouldBeAbleToSeeAllInvoices() {
        salesManagerViewInvoices.verifyInvoicesDisplay();
    }

    @When(":Sales manager comments on the invoice")
    public void salesManagerCommentsOnTheInvoice() {
        salesManagerViewInvoices.viewInvoiceAndComment1();
    }

    @Then(":Sales manager should be able to comment on the invoice")
    public void salesManagerShouldBeAbleToCommentOnTheInvoice() {
        salesManagerViewInvoices.verifyInvoicesComment();
    }


}
