@CatalogModule   @UiTest
Feature: Catalog manager can manage catalog
  Background:
    Given Catalog manager on the dashboard page

  @AddNewSearchTerms
  Scenario: catalog manager can add new search term
    Given catalog manager go to the manage catalog page
    When catalog manager add new search term
    Then add new search term should be displayed
   @EditRootCategory
    Scenario: catalog manager can edit root category
        Given catalog manager go to the manage catalog page
        When catalog manager edit root category
        Then root category should be edited successfully

     @EditSearchTerms
     Scenario: catalog Manager can edit existing search terms
       Given catalog manager go to the manage catalog page
       When catalog Manager edit existing search terms
       Then existing search terms should be successfully edited
