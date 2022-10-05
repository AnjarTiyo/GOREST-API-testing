Feature: Create a user post

  Background: Environment is set
    Given BASE_URL is set to "https://gorest.co.in/public/v1"
    And usersEndpoint is set to "/users"
    And postsEndpoint is set to "/posts"
    And commentsEndpoint is set to "/comments"
    And bearerToken is set to "3c2333def57e12a588eb567a9877a0bf629a6bc7e977432385b8d391445a689e"

  @positive @posts-001
  Scenario: POST create a user post with valid user ID and valid body
    Given set path to {{BASE_URL}}{{usersEndpoint}}{{usersID}}{{postsEndpoint}}
    And set request body to JSON data
    When click Send button
    Then API should return 200 OK
    And response body should contains post ID not null
    And assert response body to json schema