@CustomerModule   @UiTest
Feature: Customer manager can manage customers
  Background:
    Given Customer manager on the dashboard page
  @FilterCustomers
  Scenario: customer manager can filter customers by state
    Given customer manager go to the manage customer page
    When customer manager filter customers by state Breda
    Then filtered customer should be displayed

  @FilterCustomersGroup
  Scenario: customer manager can filter customers by group
    Given customer manager go to the manage customer group page
    When customer manager filter customers by group
    Then filtered customer group should be displayed
