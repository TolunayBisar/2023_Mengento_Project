Feature: an authorized admin user should be able to
  manage customers
  Scenario: an authorized admin user should be able to login customers manege page
    Given a valid username and password
    When the admin user is on the dashboard page
    Then the api should be return 200 response code

  Scenario: admin user can get all customers info and filter customers by email
  // sherti    // herket , actions // natije
    Given admin user enter <key word >  on the customer manage page in the email icon
    When admin user filter customers by email from customer manage page
    Then the api should be return 200 response code
    And the api should be return more than one customres
    Example
     | email|
     |simruh|