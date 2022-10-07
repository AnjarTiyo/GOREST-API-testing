Feature: Delete user
  Background:
    Given set path post new user to "https://gorest.co.in/public/v1/users"
    And set request body post to json data
    When send request post create new user
    Then API should return 201 created
    And API send usersID to dynamic variable
    And assert usersID not 0

  @positive @users-016
  Scenario: delete available user
    Given set path delete to "https://gorest.co.in/public/v1/users/{id}"
    When send request delete user from id "usersID"
    Then should return 204 no content

  @negative @users-017
  Scenario: delete unvailable user
    Given set path delete to "https://gorest.co.in/public/v1/users/0"
    When send request delete user from invalid "0"
    Then should return 404 not found
