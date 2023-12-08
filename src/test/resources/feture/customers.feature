@RegressionTest @CustomersFeature
Feature:  an authorized admin user should be able to
  manage customers , admin user can filter customers by Email
  as an admin ,the admin should be se personInformation

  Scenario Outline: on the login page , valid admin user can login
    Given a valid username and password
    When the admin user enters <ValidUserName> <ValidPassword>
    And the admin user clicks on the login button
    Then the user should be see the dashboard
    Examples:
      | ValidUserName | ValidPassword |
      |customermanager|automationadmin!123|



Scenario: admin user can filter customer by email
  // sherti    // herket , actions // natije
  Given admin user is on the customer module dashboard page
  When admin user filter customers by email from customer manage page
  Then Customers should be able to  get customers info  by email
