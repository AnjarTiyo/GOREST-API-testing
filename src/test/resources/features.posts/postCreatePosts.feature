Feature: Create a user post

  Background: Environment is set
    Given "BASE_URL" is set to"env.BASE_URL"
    And "usersEndpoint" is set to"env.usersEndpoint"
    And "postsEndpoint" is set to"env.postsEndpoint"
    And "usersID" is set to "env.usersID"
    And "authorization" is set to "BearerToken"

  @positive @posts-001
  Scenario: POST create a user post with valid user ID and valid body
    Given set path to {{BASE_URL}}{{usersEndpoint}}{{usersID}}{{postsEndpoint}}
    And set request body to JSON data
    When click Send button
    Then API should return 200 OK
    And response body should contains post ID not null
    And assert response body to json schema