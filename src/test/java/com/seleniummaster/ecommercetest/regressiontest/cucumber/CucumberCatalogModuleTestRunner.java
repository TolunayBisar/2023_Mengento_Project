package com.seleniummaster.ecommercetest.regressiontest.cucumber;



import com.github.javafaker.Faker;
import com.seleniummaster.ecommercetest.backend_page.customersmodule.*;
import com.seleniummaster.ecommercetest.basefunction_page.BaseClass;
import com.seleniummaster.ecommercetest.basefunction_page.LoginDataForBackEnd;
import com.seleniummaster.ecommercetest.dashboard_page.DashBoardPageForBackEnd;
import com.seleniummaster.ecommercetest.dashboard_page.LoginPageForBackEnd;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Assert;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = "classpath:features/catalog-module.feature",


        plugin ={
                "pretty",
                "html:target/cucumber-html-report.html",
                "json:target/cucumber-json-report.json",
                "junit:target/cucumber-xml-report.xml "
        },



        tags = "")




public class CucumberCatalogModuleTestRunner {

        public static class CustomersModuleStepdefs extends BaseClass {
            LoginDataForBackEnd loginDataForBackEnd = new LoginDataForBackEnd();
            LoginPageForBackEnd loginPageForBackEnd = new LoginPageForBackEnd(driver);
            DashBoardPageForBackEnd dashBoardPageForBackEnd = new DashBoardPageForBackEnd(driver);
            FilterCustomerGroupPage filterCustomerGroupPage = new FilterCustomerGroupPage(driver);
            AssignCustomerToGroup assignCustomerToGroup = new AssignCustomerToGroup(driver);

            CustomerManagerAddNewCustomerGroup customerManagerAddNewCustomerGroup = new CustomerManagerAddNewCustomerGroup(driver);

            PageForDeleteCustomer pageForDeleteCustomer = new PageForDeleteCustomer(driver);
            AddCustomer addCustomer=new AddCustomer(driver);
            String customerEmail = "Team3"+ Faker.instance().internet().emailAddress();



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

                pageForDeleteCustomer.setDeleteCustomer();
            }

            @Then("the customer should be deleted")
            public void theCustomerShouldBeDeleted() {
                pageForDeleteCustomer.verifyCustomerDeleted();
                Assert.assertTrue(pageForDeleteCustomer.verifyCustomerDeleted());
            }
            @When("Customer manager can add new customer")
            public void customerManagerCanAddNewCustomer() {
                addCustomer.addNewCustomer(customerEmail);
            }

            @Then("The new customer is added in the system")
            public void theNewCustomerIsAddedInTheSystem() {
                addCustomer.verifyForAddingNewCustomer();
            }


        }
}





