@DatabaseTest

Feature: Verify Magento Application By Database

  Background:
    Given As a user connected to the database with valid credentials


  @DatabaseAddNewCartPriceRule
  Scenario: Verify newly added Cart Price Rule in the database
    Given the manager has valid data base connection
    When  execute SQl query to get the new Cart Price Rule information from the database
    Then  the database should contain the newly added Cart Price Rule

    Scenario: Verify newly added Credit Memo in database
      When execute SQl query to get the new Credit Memo  information from the database
      Then  the database should contain the newly added Credit Memo