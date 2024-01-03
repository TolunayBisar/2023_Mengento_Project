package com.seleniummaster.ecommercetest.regressiontest.cucumber.stepdefinations;

import com.seleniummaster.ecommercetest.backend_page.marketingmodule.MarketingManagerAllView;
import com.seleniummaster.ecommercetest.basefunction_page.BaseClass;
import com.seleniummaster.ecommercetest.basefunction_page.LoginDataForBackEnd;
import com.seleniummaster.ecommercetest.dashboard_page.DashBoardPageForBackEnd;
import com.seleniummaster.ecommercetest.dashboard_page.LoginPageForBackEnd;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MarketingModuleStepdefs extends BaseClass {
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

