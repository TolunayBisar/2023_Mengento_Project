@CustomerModule   @UiTest
Feature: Customer manager can manage customers
  Background:
    Given Customer manager on the dashboard page

  @FilterCustomersGroup
  Scenario: customer manager can filter customers by group
    Given customer manager go to the manage customer group page
    When customer manager filter customers by group
    Then filtered customer group should be displayed
