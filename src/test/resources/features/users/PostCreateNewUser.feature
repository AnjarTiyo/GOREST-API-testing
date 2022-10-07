Feature: Create New Users
#  Background: Create new users to generate valid usersID due to dynamic resources
#    Given set path post new user to "https://gorest.co.in/public/v1/users"
#    And set request body post to json data
#    When send request post create new user
#    Then API should return 201
#    And API send usersID to dynamic variable
#    And assert usersID not 0

  @positive @users-001
  Scenario: post create new user with valid data
    Given set path post new user to "https://gorest.co.in/public/v1/users"
    And set request body post to json data
    When send request post create new user
    Then API should return 201 created
    And post create new user json schema
    And API send usersID to dynamic variable
    And assert usersID not 0

  @negative @users-002
  Scenario: post create new user with invalid json
    Given set path post new user to "https://gorest.co.in/public/v1/users"
    And set request body post to invalid json data
    When send request post create new user
    Then API should return 422 Unprocessable Entity
    And post create new user invalid json schema