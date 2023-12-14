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
  Scenario: catalog manager can filter search terms SearchQuery
    Given catalog manager go to the manage catalog page
    When catalog manager filter search terms by SearchQuery
    Then filter result should be display on the page
  @FilterSearchTerms
  Scenario: catalog manager can filter search terms By Store
    Given catalog manager go to the manage catalog page
    When catalog manager filter search terms by Store
    Then filter result should be display on the page

  @FilterSearchTerms
  Scenario: catalog manager can filter search terms by Result
    Given catalog manager go to the manage catalog page
    When catalog manager filter search terms by Result
    Then filter result should be display on the page

  @FilterSearchTerms
  Scenario: catalog manager can filter search terms by Use
    Given catalog manager go to the manage catalog page
    When catalog manager filter search terms by Use
    Then filter result should be display on the page

  @FilterSearchTerms
  Scenario: catalog manager can filter search terms by Synonym
    Given catalog manager go to the manage catalog page
    When catalog manager filter search terms by Synonym
    Then filter result should be display on the page

  @FilterSearchTerms
  Scenario: catalog manager can filter search terms Suggested Terms
    Given catalog manager go to the manage catalog page
    When catalog manager filter search terms by Suggested Terms
    Then filter result should be display on the page









     @EditSearchTerms
     Scenario: catalog Manager can edit existing search terms
       Given catalog manager go to the manage catalog page
       When catalog Manager edit existing search terms
       Then existing search terms should be successfully edited


    @AddProduct
    Scenario: Catalog manager can add products
#      Given Catalog manager go to the manage catalog page
      When Catalog manager added product
      Then product should be successfully added and success message should be displayed