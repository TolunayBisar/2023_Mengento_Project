Feature: admin user should be able to view customers information in the Magento_inventory table

  Scenario: admin user should be able to get customer info
    Given admin has read access to the magento_inventory table
    When the admin user filter customer by email
    Then the admin user view customers information on the table