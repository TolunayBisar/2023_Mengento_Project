@ReportingModule   @UiTest
Feature: Reporting manager can manage reporting
  Background:
    Given Reporting manager on the dashboard page

    @ReportingTotalOrders
    Scenario: Reporting manager can see total orders
        Given Reporting manager must be on the dashboard page
        When  Reporting manager clicks on the total orders link
        Then  Reporting manager able to see the total orders