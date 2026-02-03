Feature: User Management API Validation

  @regression @positive
  Scenario Outline: Create user validation (Standard and Optional fields)
    Given I create a user with the following details:
      | firstName   | secondName   | lastName   | email   | password   |
      | <firstName> | <secondName> | <lastName> | <email> | <password> |
    Then the response status should be 201
    And the response should contain the following user details:
      | firstName   | email   |
      | <firstName> | <email> |

    Examples:
      | firstName | secondName | lastName | email          | password |
      | John      | D.         | Doe      | john@email.com | pass123  |
      | John      | D.         | [blank]  | john@email.com | pass123  |

  @regression @negative
  Scenario: Try to create user without mandatory firstName
    Given I create a user with the following details:
      | lastName | email          | password |
      | Smith    | smith@mail.com | pass123  |
    Then the response status should be 400

  @regression @positive
  Scenario: Successfully retrieve user by ID
    Given I create a user with the following details:
      | firstName | email          |
      | John      | john@email.com |
    When I request the user by current ID
    Then the response status should be 200

  @regression @negative
  Scenario: Handle non-existing user retrieval
    When I request user with id 999
    Then the response status should be 404