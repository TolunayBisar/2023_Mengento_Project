/*package backend.customersmodule;

import basefunc.LoginDataForBackEnd;
import dashboard.DashBoardPageForBackEnd;
import dashboard.LoginPageForBackEnd;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

/*public class DeleteCustomerSteps {
    WebDriver driver ;
    LoginPageForBackEnd loginPageForBackEnd;
    LoginDataForBackEnd loginDataForBackEnd;
    DashBoardPageForBackEnd dashBoardPageForBackEnd;
    PageForDeleteCustomer pageForDeleteCustomer;
    @Given("admin user is on the dashboard page")
    public void adminUserIsOnTheDashboardPage() {
        loginPageForBackEnd=new LoginPageForBackEnd(driver);
        loginDataForBackEnd=new LoginDataForBackEnd();
        dashBoardPageForBackEnd=new DashBoardPageForBackEnd(driver);
        loginPageForBackEnd.logIn(loginDataForBackEnd.getUsernameCustomerManager(),loginDataForBackEnd.getPassword());
        Assert.assertTrue(dashBoardPageForBackEnd.verifyCustomerModuleDashboardOpened());
    }

    @When("the user tries to delete an existing customer")
    public void theUserTriesToDeleteAnExistingCustomer() {
        dashBoardPageForBackEnd.clickOnCustomerTab();
        pageForDeleteCustomer.setDeleteCustomer();
    }

    @Then("the customer should be deleted")
    public void theCustomerShouldBeDeleted() {
        pageForDeleteCustomer.verifyCustomerDeleted();
        Assert.assertTrue(pageForDeleteCustomer.verifyCustomerDeleted());
    }
}*/
