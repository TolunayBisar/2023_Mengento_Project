package backend.customersmodule;

import basefunc.BaseClassForBackend;
import basefunc.LoginDataForBackEnd;
import dashboard.LoginPageForBackEnd;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Customer_ModuleExportStepdefs extends BaseClassForBackend {


   LoginPageForBackEnd loginPageForBackEnd = new LoginPageForBackEnd(driver);
   LoginDataForBackEnd loginDataForBackEnd = new LoginDataForBackEnd();
    ExportCustomersPage exportCustomersPage = new ExportCustomersPage(driver);
    @Given("the admin user should be able to login successfully")
    public void theAdminUserShouldBeAbleToLoginSuccessfully() {
        loginPageForBackEnd.logIn(loginDataForBackEnd.getUsernameCustomerManager(), loginDataForBackEnd.getPassword());

    }

    @When("the admin user should be able to export customers csv")
    public void theAdminUserShouldBeAbleToExportCustomersCsv() {
        exportCustomersPage.exportCustomers();
    }

    @Then("customers csv file should be able to visible on Downloadable folder")
    public void customersCsvFileShouldBeAbleToVisibleOnDownloadableFolder() {
        exportCustomersPage.verifyFileExist();
    }
}
