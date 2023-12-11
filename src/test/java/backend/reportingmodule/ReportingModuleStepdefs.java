package backend.reportingmodule;

import basefunc.BaseClassForBackend;
import basefunc.LoginDataForBackEnd;
import dashboard.DashBoardPageForBackEnd;
import dashboard.LoginPageForBackEnd;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReportingModuleStepdefs extends BaseClassForBackend {
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
