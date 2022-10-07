Feature: Retrieves single user
Background:
  Given set path post new user to "https://gorest.co.in/public/v1/users"
  And set request body post to json data
  When send request post create new user
  Then API should return 201 created
  And API send usersID to dynamic variable
  And assert usersID not 0

  @positive @users-009
  Scenario: get single user with valid id
    Given set path to single user "https://gorest.co.in/public/v1/users/{id}"
    When send request get single users from id "usersID"
    Then should return 200 ok
    And API send id to dynamic variable
    And get single user json schema
    And assert usersID not 0

  @negative @users-010
  Scenario: get unavailable user
    Given set path to single user "https://gorest.co.in/public/v1/users/0" invalid id
    When send request get single users from invalid id "0"
    Then should return 404 not found
    And response body should contain message "Resource not found"
    And get single user invalid id json schema

  @negative @users-011
  Scenario: get single user with invalid string id
    Given set path to single user "https://gorest.co.in/public/v1/users/ed" invalid id
    When send request get single users from invalid id "ed"
    Then should return 404 not found
    And response body should contain message "Resource not found"
    And get single user invalid id json schema

  @negative @users-012
  Scenario: get single user with invalid special char id
    Given set path to single user "https://gorest.co.in/public/v1/users/***" invalid id
    When send request get single users from invalid id "***"
    Then should return 404 not found
    And response body should contain message "Resource not found"
    And get single user invalid id json schema
