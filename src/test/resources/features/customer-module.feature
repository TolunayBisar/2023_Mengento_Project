@CustomerModule   @UiTest @RegressionTest
Feature: Customer manager can manage customers
  Background:
    Given Customer manager on the dashboard page

  @FilterCustomersGroup
  Scenario: customer manager can filter customers by group
    Given customer manager go to the manage customer group page
    When customer manager filter customers by group
    Then filtered customer group should be displayed

  @AssignCustomer
  Scenario: Customer Manager Can Assign a Customer To a Customer Group In The Actions
  On The All Customer page
    Given customer manager go to the manage customer page
    When the Customer Manager assigns a customer to a Customer Group
    Then the operation should be successful

