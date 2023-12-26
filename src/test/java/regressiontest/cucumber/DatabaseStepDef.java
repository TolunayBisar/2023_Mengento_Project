package regressiontest.cucumber;

import basefunc.ConnectionType;
import basefunc.DataBaseConnection;
import basefunc.DataClassForDB;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import magentodatabase.VerifySQLNewlyAddedCreditMemo;
import magentodatabase.VerifySQLScriptsNewPriceRule;
import org.junit.Assert;

import java.sql.Connection;

import static basefunc.FunctionLibrary.readFromConfig;

public class DatabaseStepDef {
    Connection connection;
    DataClassForDB dataClassForDB;
    VerifySQLScriptsNewPriceRule verifySQLScriptsNewPriceRule;
    VerifySQLNewlyAddedCreditMemo verifySQLNewlyAddedCreditMemo;




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
}
