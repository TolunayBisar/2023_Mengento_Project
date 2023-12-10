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
     @FilterSearchTerms
     Scenario: catalog manager can filter search terms
       Given catalog manager go to the manage catalog page
       When catalog manager filter search terms by SearchQuery
       When catalog manager filter search terms by Store
       When catalog manager filter search terms by Result
       When catalog manager filter search terms by Use
       When catalog manager filter search terms by Synonym
       When catalog manager filter search terms by Suggested Terms
       Then filter result should be display on the page