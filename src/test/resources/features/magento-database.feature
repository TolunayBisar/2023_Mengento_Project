@DatabaseTest

Feature: Verify Magento Application By Database

  Background:
    Given As a user connected to the database with valid credentials


  @DatabaseAddNewCartPriceRule
  Scenario: Verify newly added Cart Price Rule in the database
    Given the manager has valid data base connection
    When  execute SQl query to get the new Cart Price Rule information from the database
    Then  the database should contain the newly added Cart Price Rule

@DatabaseAddNewCreditMemos
    Scenario: Verify newly added Credit Memo in database
      When execute SQl query to get the new Credit Memo  information from the database
      Then  the database should contain the newly added Credit Memo

  @DatabaseAddNewCustomerGroups
  Scenario: Verify newly added Customer Group in database
    When execute SQl query to get the new Customer Group  information from the database
    Then  the database should contain the newly added Customer Group

  @DatabaseAddNewRootCategory
  Scenario: Verify newly added Root Category in database
    When execute SQl query to get the new Root Category  information from the database
    Then  the database should contain the newly added Root Category

  @DatabaseAddNewOrder
  Scenario: Verify newly added Order in database
    When execute SQl query to get the new Order  information from the database
    Then  the database should contain the newly added Order

  @DatabaseAddNewStore
  Scenario: Verify newly added Store in database
    When execute SQl query to get the new Store  information from the database
    Then  the database should contain the newly added Store

  @DatabaseAddNewTaxRule
  Scenario: Verify newly added Tax Rule in database
    When execute SQl query to get the new Tax Rule  information from the database
    Then  the database should contain the newly added Tax Rule