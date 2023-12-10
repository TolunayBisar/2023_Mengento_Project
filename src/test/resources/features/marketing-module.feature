@MarketingModule   @UiTest
Feature: Marketing manager can manage marketing
  Background:
    Given Marketing manager on the dashboard page

    @ViewAllReviews
    Scenario: Marketing manager can view all reviews
      Given Marketing manager must be on the dashboard page
        When Marketing manager clicks on the customer reviews link
        Then Marketing manager should see all customer reviews
        When Marketing manager clicks on the product reviews link
        Then Marketing manager should see all product reviews

