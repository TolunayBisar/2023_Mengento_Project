@StoreModule   @UiTest
Feature: Store manager can manage Store
  Background:
    Given Store manager on the dashboard page
    @CancelOrder
    Scenario:StoreManager able to cancel order in the system
     Given Store manager must be on the dashboard page
     When Store manager click on the Orders link for cancel order
     Then Store manager should be able to click on any order

