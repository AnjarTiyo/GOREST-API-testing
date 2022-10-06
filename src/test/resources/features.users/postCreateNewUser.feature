Feature: Create new user

  Background: Environment is set
#    Given BASE_URL is set to "https://gorest.co.in/public/v1"
#    And usersEndpoint is set to "/users"
#    Given bearerToken is set to "3c2333def57e12a588eb567a9877a0bf629a6bc7e977432385b8d391445a689e"

    @positive @users-001
    Scenario: post create new user with valid data
      Given set path to "https://gorest.co.in/public/v1/users"
      And set request body post to json data
      When send request post create new user
      Then should return 201 created
      And post create new user json schema
      And API send usersID to dynamic variable

    @negative @users-002
    Scenario: post create new user with invalid json
      Given set path to {{BASE_URL}}{{usersEndpoint}}
      And set request body post to invalid json data
      When send request post create new user
      Then should return 422 unprocessable entity
      And response body should contains field "email" and message "can't be blank"
      And post create new user json schema

    @negative @users-003
    Scenario: post create new user with existing json data
      Given set path to {{BASE_URL}}{{usersEndpoint}}
      And set request body post to existing json data
      When send request post create new user
      Then should return 422 unprocessable entity
      And response body should contains field "email" and message "has already been taken"
      And post create new user json schema

