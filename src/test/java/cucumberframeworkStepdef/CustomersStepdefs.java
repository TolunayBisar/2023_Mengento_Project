package cucumberframeworkStepdef;

import basefunc.BaseClass;
import dashboard.LoginPageForBackEnd;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.devtools.v85.backgroundservice.BackgroundService;

/**
 * @author :
 * @created : 12/6/2023,2:58 PM
 * @Email : abdanna369@gmail.com
 **/
public class CustomersStepdefs extends BaseClass {
    LoginPageForBackEnd loginPageForBackEnd;
    @Given("a valid username and password")
    public void aValidUsernameAndPassword() {
        
    }
    @When("the admin user enters <ValidUserName> <ValidPassword>")
    public void theAdminUserEntersValidUserNameValidPassword() {

    }

    @And("the admin user clicks on the login button")
    public void theAdminUserClicksOnTheLoginButton() {

    }

    @Then("the user should be see the dashboard")
    public void theUserShouldBeSeeTheDashboard() {
    }
}
