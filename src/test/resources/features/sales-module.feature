@SalesModule   @UiTest
Feature: Sales manager can manage Sales
  Background:
    Given Sales manager on the dashboard page
@ViewInvoicesAndComments
Scenario: Sales manager can view all invoices and able to comment on
        Given :Sales manager must be on the dash board page
        When :Sales manager click on the views link for invoices
        Then :Sales manager should be able to see all invoices
        When :Sales manager comments on the invoice
        Then :Sales manager should be able to comment on the invoice