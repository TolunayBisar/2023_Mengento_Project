package regressiontest.cucumber;

import backend.customersmodule.AssignCustomerToGroup;
import backend.customersmodule.CustomerManagerAddNewCustomerGroup;
import backend.customersmodule.FilterCustomerGroupPage;
import backend.customersmodule.PageForDeleteCustomer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import basefunc.BaseClassForBackend;
import basefunc.LoginDataForBackEnd;
import dashboard.DashBoardPageForBackEnd;
import dashboard.LoginPageForBackEnd;
import org.junit.Assert;
import org.testng.annotations.AfterClass;

public class CustomersModuleStepdefs extends BaseClassForBackend{
    LoginDataForBackEnd loginDataForBackEnd = new LoginDataForBackEnd();
    LoginPageForBackEnd loginPageForBackEnd = new LoginPageForBackEnd(driver);
    DashBoardPageForBackEnd dashBoardPageForBackEnd = new DashBoardPageForBackEnd(driver);
    FilterCustomerGroupPage filterCustomerGroupPage = new FilterCustomerGroupPage(driver);
    AssignCustomerToGroup assignCustomerToGroup = new AssignCustomerToGroup(driver);

    CustomerManagerAddNewCustomerGroup customerManagerAddNewCustomerGroup = new CustomerManagerAddNewCustomerGroup(driver);

    PageForDeleteCustomer pageForDeleteCustomer = new PageForDeleteCustomer(driver);



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

    @Given("customer manager go to the manage customer page")
    public void customerManagerGoToTheManageCustomerPage() {
        dashBoardPageForBackEnd.goToManageCustomersPage();
    }

    @When("the Customer Manager assigns a customer to a Customer Group")
    public void theCustomerManagerAssignsACustomerToACustomerGroup() {
        assignCustomerToGroup.addNewCustomerToCustomerGroup();


    }

    @Then("the operation should be successful")
    public void theOperationShouldBeSuccessful() {
        assignCustomerToGroup.verifyCustomerAssignToCustomerGroup();
    }


    @Given("Customer manager go to the manage customer page")
    public void CustomerManagerGoToTheManageCustomerPage() {
        dashBoardPageForBackEnd.goToManageCustomersPage2();

    }

    @When("Customer manager add new customer group.")
    public void customerManagerAddNewCustomerGroup() {
        customerManagerAddNewCustomerGroup.addNewCustomerGroup();

    }

    @Then("Added new customer group should be displayed.")
    public void addedNewCustomerGroupShouldBeDisplayed() {
        customerManagerAddNewCustomerGroup.verifyAddedNewCustomerGroup();
    }





    @Given("admin user is on the dashboard page")
    public void adminUserIsOnTheDashboardPage() {
        dashBoardPageForBackEnd.goToManageCustomersPage();
    }

    @When("the user tries to delete an existing customer")
    public void theUserTriesToDeleteAnExistingCustomer() {
        pageForDeleteCustomer.setDeleteCustomer("shane.muller@yahoo.com");
    }

    @Then("the customer should be deleted")
    public void theCustomerShouldBeDeleted() {
        pageForDeleteCustomer.verifyCustomerDeleted();
        Assert.assertTrue(pageForDeleteCustomer.verifyCustomerDeleted());
    }

}





