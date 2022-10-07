Feature: Patch update comments

  Background: Environment is set
    Given BASE_URL is set to "https://gorest.co.in/public/v1"
    And usersEndpoint is set to "/users"
    And postsEndpoint is set to "/posts"
    And commentsEndpoint is set to "/comments"
    And bearerToken is set to "3c2333def57e12a588eb567a9877a0bf629a6bc7e977432385b8d391445a689e"

  @comments-019
  Scenario: PATCH one comment within valid json
    Given set path to {{BASE_URL}}{{commentEndpoint}}
    And set request body to JSON data
    When click send button
    Then API should return 200 OK"