package backend.customersmodule;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import basefunc.BaseClassForBackend;
import basefunc.LoginDataForBackEnd;
import dashboard.DashBoardPageForBackEnd;
import dashboard.LoginPageForBackEnd;

public class CustomersModuleStepdefs extends BaseClassForBackend{
    LoginDataForBackEnd loginDataForBackEnd = new LoginDataForBackEnd();
    LoginPageForBackEnd loginPageForBackEnd = new LoginPageForBackEnd(driver);
    DashBoardPageForBackEnd dashBoardPageForBackEnd = new DashBoardPageForBackEnd(driver);
    FilterCustomerGroupPage filterCustomerGroupPage = new FilterCustomerGroupPage(driver);

    @Given("Customer manager on the dashboard page")
    public void customerManagerOnTheDashboardPage() {
        loginPageForBackEnd.logIn(loginDataForBackEnd.getUsernameCustomerManager(),loginDataForBackEnd.getPassword());
        dashBoardPageForBackEnd.verifyCustomerModuleDashboardPage();
    }

    @Given("customer manager go to the manage customer group page")
    public void customerManagerGoToTheManageCustomerGroupPage() {
        dashBoardPageForBackEnd.goToManageCustomersPage();
    }

    @When("customer manager filter customers by group")
    public void customerManagerFilterCustomersByGroup() {
        filterCustomerGroupPage.filterCustomersGroup();

    }

    @Then("filtered customer group should be displayed")
    public void filteredCustomerGroupShouldBeDisplayed() {
        filterCustomerGroupPage.verifyFilterCustomersGroup();
    }
}
