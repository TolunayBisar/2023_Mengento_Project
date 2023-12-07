@customerModule @UiTest
Feature: the admin user can manage customers module
  Scenario: the admin user should be able to export customers
    Given the admin user should be able to login successfully
    When the admin user should be able to export customers csv
    Then customers csv file should be able to visible on Downloadable folder