package backend.marketingmodule;

import basefunc.BaseClassForBackend;
import basefunc.LoginDataForBackEnd;
import dashboard.DashBoardPageForBackEnd;
import dashboard.LoginPageForBackEnd;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MarketingModuleStepdefs extends BaseClassForBackend {
    LoginDataForBackEnd loginDataForBackEnd = new LoginDataForBackEnd();
    LoginPageForBackEnd loginPageForBackEnd = new LoginPageForBackEnd(driver);
    DashBoardPageForBackEnd dashBoardPageForBackEnd = new DashBoardPageForBackEnd(driver);
    MarketingManagerAllView marketingManagerAllView = new MarketingManagerAllView(driver);
    @Given("Marketing manager on the dashboard page")
    public void marketingManagerOnTheDashboardPage() {
        loginPageForBackEnd.logIn(loginDataForBackEnd.getUsernameMarketingManager()
                ,loginDataForBackEnd.getPassword());
        dashBoardPageForBackEnd.verifyMarketingModuleDashboardOpened();


    }

    @Given("Marketing manager must be on the dashboard page")
    public void marketingManagerMustBeOnTheDashboardPage() {
    }

    @When("Marketing manager clicks on the customer reviews link")
    public void marketingManagerClicksOnTheCustomerReviewsLink() {
        marketingManagerAllView.viewAllCustomerReviews();
    }


    @Then("Marketing manager should see all customer reviews")
    public void marketingManagerShouldSeeAllCustomerReviews() {
        marketingManagerAllView.verifyCustomerReviewsOpened();
    }


    @When("Marketing manager clicks on the product reviews link")
    public void marketingManagerClicksOnTheProductReviewsLink() {
        marketingManagerAllView.viewAllProductReviews();
    }

    @Then("Marketing manager should see all product reviews")
    public void marketingManagerShouldSeeAllProductReviews() {
        marketingManagerAllView.verifyProductReviewsOpened();
    }
}

