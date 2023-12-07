package cucumberframeworkStepdef;

import basefunc.LoginDataForBackEnd;
import dashboard.DashBoardPageForBackEnd;
import dashboard.LoginPageForBackEnd;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

/**
 * @author :
 * @created : 12/6/2023,8:36 PM
 * @Email : abdanna369@gmail.com
 **/
public class MyStepdefs {
    WebDriver driver;
    LoginPageForBackEnd loginPageForBackEnd;
    LoginDataForBackEnd loginDataForBackEnd;
    DashBoardPageForBackEnd dashBoardPageForBackEnd;

    @Given("a valid username and password")
    public void aValidUsernameAndPassword() {

    }

    @When("the admin user enters {}{}")
    public void theAdminUserEntersValidUserNameValidPassword() {
    }


    @And("the admin user clicks on the login button")
    public void theAdminUserClicksOnTheLoginButton() {
    }

    @Then("the user should be see the dashboard")
    public void theUserShouldBeSeeTheDashboard() {
    }
}
