Feature: Managing All Module in Application via API
  As Admin user I want to manage customer, customer group, product and category using th API.
  So that I can perform Create, Read ,Update , Read operation on these all features.
  Background:
    Given an authorized user with valid API

    Scenario: Authorized user should be able to create new product via API
      When the user sends a POST request to create a new product
      Then Response must be with a 200 status code

  Scenario: Authorized user should be able to update customer group info via API
    When the user sends a PUT request to update customer group 0 info
    Then Response must be with a 204 status code

  Scenario: Authorized user should be able to update customer info via API
    Given an authorized user with valid API
    When the user sends a PUT request to update customer 341 info
    Then Response must be with a 200 status code

  Scenario Outline: Authorized user should be able to get category info via API
    When the user sends a GET request to retrieve category <CategoryId> info
    Then Response must be with a 200 status code
#    And the response must return correct with category name <CategoryValue>
    Examples:
      |CategoryId|CategoryValue|
      | 1           |    cbus  |
      |8          | Mobile phone  |

