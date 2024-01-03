package com.seleniummaster.ecommercetest.regressiontest.cucumber.stepdefinations;

import com.seleniummaster.ecommercetest.basefunction_page.ConnectionType;
import com.seleniummaster.ecommercetest.basefunction_page.DataBaseConnection;
import com.seleniummaster.ecommercetest.basefunction_page.DataClassForDB;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.seleniummaster.ecommercetest.database.*;
import org.junit.Assert;

import java.sql.Connection;

import static com.seleniummaster.ecommercetest.basefunction_page.FunctionLibrary.readFromConfig;

public class DatabaseStepDef {
    Connection connection;
    DataClassForDB dataClassForDB;
    VerifySQLScriptsNewPriceRule verifySQLScriptsNewPriceRule;
    VerifySQLNewlyAddedCreditMemo verifySQLNewlyAddedCreditMemo;
    VerifySQLNewAddedCustomerGroup verifySQLNewAddedCustomerGroup;
    VerifySQLNewlyAddedProductRootCategory verifyNewlyAddedProductRootCategory;
   VerifySQLNewlyAddedOrder verifySQLNewlyAddedOrder;
   VerifySQLNewlyAddedStore verifySQLNewlyAddedStore;
   VerifySQLNewlyAddedTaxRule verifySQLNewlyAddedTaxRule;



    @Given("As a user connected to the database with valid credentials")
    public void asAUserConnectedToTheDatabaseWithValidCredentials() {
        String dbUrl = readFromConfig("dburl");
        String dbPort = readFromConfig("dbport");
        String userName = readFromConfig("dbusername");
        String password = readFromConfig("dbpassword");
        String dbName = readFromConfig("dbname");
        DataBaseConnection dbConnection = new DataBaseConnection();
        connection = dbConnection.connectToDataBaseServer(dbUrl, dbPort, userName, password, dbName, ConnectionType.MYSQL);
        dataClassForDB = new DataClassForDB();
        verifySQLScriptsNewPriceRule = new VerifySQLScriptsNewPriceRule();
verifySQLNewlyAddedCreditMemo = new VerifySQLNewlyAddedCreditMemo();
verifySQLNewAddedCustomerGroup = new VerifySQLNewAddedCustomerGroup();
verifyNewlyAddedProductRootCategory = new VerifySQLNewlyAddedProductRootCategory();
verifySQLNewlyAddedOrder = new VerifySQLNewlyAddedOrder();
verifySQLNewlyAddedStore = new VerifySQLNewlyAddedStore();
verifySQLNewlyAddedTaxRule = new VerifySQLNewlyAddedTaxRule();



    }
    @Given("the manager has valid data base connection")
    public void theManagerHasValidDataBaseConnection() {
    }
    @When("execute SQl query to get the new Cart Price Rule information from the database")
    public void executeSQlQueryToGetTheNewCartPriceRuleInformationFromTheDatabase() {
        verifySQLScriptsNewPriceRule.getNewAddedPriceRule(connection, "buy 1 get 1 free");

    }
    @Then("the database should contain the newly added Cart Price Rule")
    public void theDatabaseShouldContainTheNewlyAddedCartPriceRule() {
        boolean isAdded = verifySQLScriptsNewPriceRule.getNewAddedPriceRule(connection, "buy 1 get 1 free");
        Assert.assertTrue(isAdded);

    }


    @When("execute SQl query to get the new Credit Memo  information from the database")
    public void executeSQlQueryToGetTheNewCreditMemoInformationFromTheDatabase() {
        verifySQLNewlyAddedCreditMemo.verifySQLNewlyAddedCreditMemo(connection,"400000065-1");
    }

    @Then("the database should contain the newly added Credit Memo")
    public void theDatabaseShouldContainTheNewlyAddedCreditMemo() {
        Assert.assertTrue(verifySQLNewlyAddedCreditMemo.verifySQLNewlyAddedCreditMemo(connection,"400000065-1"));
    }

    @When("execute SQl query to get the new Customer Group  information from the database")
    public void executeSQlQueryToGetTheNewCustomerGroupInformationFromTheDatabase() {
        verifySQLNewAddedCustomerGroup.verifySQLNewlyAddedCreditMemo(connection,"LondonTeam");
    }

    @Then("the database should contain the newly added Customer Group")
    public void theDatabaseShouldContainTheNewlyAddedCustomerGroup() {
        Assert.assertTrue(verifySQLNewAddedCustomerGroup.verifySQLNewlyAddedCreditMemo(connection,"LondonTeam"));
    }

    @When("execute SQl query to get the new Root Category  information from the database")
    public void executeSQlQueryToGetTheNewRootCategoryInformationFromTheDatabase() {
        verifyNewlyAddedProductRootCategory.verifyNewlyAddedProductRootCategory(connection,"Team3-Root");
    }

    @Then("the database should contain the newly added Root Category")
    public void theDatabaseShouldContainTheNewlyAddedRootCategory() {
        Assert.assertTrue(verifyNewlyAddedProductRootCategory.verifyNewlyAddedProductRootCategory(connection,"Team3-Root"));
    }

    @When("execute SQl query to get the new Order  information from the database")
    public void executeSQlQueryToGetTheNewOrderInformationFromTheDatabase() {
        verifySQLNewlyAddedOrder.verifySQLNewlyAddedOrder(connection,"400000066");
    }

    @Then("the database should contain the newly added Order")
    public void theDatabaseShouldContainTheNewlyAddedOrder() {
        Assert.assertTrue(verifySQLNewlyAddedOrder.verifySQLNewlyAddedOrder(connection,"400000066"));
    }

    @When("execute SQl query to get the new Store  information from the database")
    public void executeSQlQueryToGetTheNewStoreInformationFromTheDatabase() {
        verifySQLNewlyAddedStore.verifySQLNewlyAddedStore(connection,"London");
    }

    @Then("the database should contain the newly added Store")
    public void theDatabaseShouldContainTheNewlyAddedStore() {
        Assert.assertTrue(verifySQLNewlyAddedStore.verifySQLNewlyAddedStore(connection,"London"));
    }

    @When("execute SQl query to get the new Tax Rule  information from the database")
    public void executeSQlQueryToGetTheNewTaxRuleInformationFromTheDatabase() {
        verifySQLNewlyAddedTaxRule.verifySQLNewlyAddedTaxRule(connection,"Tax Free For Team3");
    }

    @Then("the database should contain the newly added Tax Rule")
    public void theDatabaseShouldContainTheNewlyAddedTaxRule() {
        Assert.assertTrue(verifySQLNewlyAddedTaxRule.verifySQLNewlyAddedTaxRule(connection,"Tax Free For Team3"));
    }
}
