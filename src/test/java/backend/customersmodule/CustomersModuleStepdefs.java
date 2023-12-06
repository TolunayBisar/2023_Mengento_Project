package backend.customersmodule;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import backend.BaseClassForBackend;
import basefunc.LoginDataForBackEnd;
import dashboard.DashBoardPageForBackEnd;
import dashboard.LoginPageForBackEnd;

public class CustomersModuleStepdefs extends BaseClassForBackend{
    LoginDataForBackEnd loginDataForBackEnd = new LoginDataForBackEnd();
    LoginPageForBackEnd loginPageForBackEnd = new LoginPageForBackEnd(driver);
    DashBoardPageForBackEnd dashBoardPageForBackEnd = new DashBoardPageForBackEnd(driver);
    FilterCustomersByState filterCustomersByState = new FilterCustomersByState(driver);
    FilterCustomerGroupPage filterCustomerGroupPage = new FilterCustomerGroupPage(driver);

    @Given("Customer manager on the dashboard page")
    public void customerManagerOnTheDashboardPage() {
        loginPageForBackEnd.logIn(loginDataForBackEnd.getUsernameCustomerManager(),loginDataForBackEnd.getPassword());
        dashBoardPageForBackEnd.verifyCustomerModuleDashboardPage();
    }

    @Given("customer manager go to the manage customer page")
    public void customerManagerGoToTheManageCustomerPage() {
        dashBoardPageForBackEnd.goToManageCustomersPage();
    }

    @When("customer manager filter customers by state {}")
    public void customerManagerFilterCustomersByStateBreda(String stateName) {
        filterCustomersByState.filterCustomersByStateMethod(stateName);
    }

    @Then("filtered customer should be displayed")
    public void filteredCustomerShouldBeDisplayed() {
        filterCustomersByState.verifyCustomersFilteredByState();
    }

    @Given("customer manager go to the manage customer group page")
    public void customerManagerGoToTheManageCustomerGroupPage() {
        dashBoardPageForBackEnd.goToManageCustomersPage();
    }

    @When("customer manager filter customers by group")
    public void customerManagerFilterCustomersByGroup() {
        //dashBoardPageForBackEnd.clickOnResetFilterTab();
        filterCustomerGroupPage.filterCustomersGroup();

    }

    @Then("filtered customer group should be displayed")
    public void filteredCustomerGroupShouldBeDisplayed() {
        filterCustomerGroupPage.verifyFilterCustomersGroup();
    }
}
