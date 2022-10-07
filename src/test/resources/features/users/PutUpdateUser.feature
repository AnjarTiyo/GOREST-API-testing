Feature: Update user
  Background:
    Given set path post new user to "https://gorest.co.in/public/v1/users"
    And set request body post to json data
    When send request post create new user
    Then API should return 201
    And API send usersID to dynamic variable
    And assert usersID not 0

  @positive @users-013
  Scenario: put update user with valid id and valid json
    Given set path update to "https://gorest.co.in/public/v1/users/{id}"
    And set request body put to valid json data
    When send request put update user
    Then should return 200 ok
    And put update user json schema

  @negative @users-0014
  Scenario: put update unavailable user
    Given set path update to "https://gorest.co.in/public/v1/users/0"
    When send request put update user
    Then should return 404 not found
    And response body should contain message "Resource not found"
    And put update unavailable user json schema

  @negative @users-015
  Scenario: put update user with invalid json
    Given set path update to "https://gorest.co.in/public/v1/users/{id}"
    And set request body put to invalid json data
    When send request put update user
    Then should return 400 bad request

