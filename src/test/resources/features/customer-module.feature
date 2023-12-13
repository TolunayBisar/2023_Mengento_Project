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


  @AddNewCustomerGroup
  Scenario: Customer manager should be able to add new customer group.
    Given Customer manager go to the manage customer page
    When Customer manager add new customer group.
    Then Added new customer group should be displayed.

  @DeleteCustomer
  Scenario: admin user can delete an existing customer
    Given admin user is on the dashboard page
    When the user tries to delete an existing customer
    Then the customer should be deleted

  @AddNewCustomer
  Scenario: Customer manager can add a new customer
    Given customer manager go to the manage customer page
    When Customer manager can add new customer
    Then The new customer is added in the system



