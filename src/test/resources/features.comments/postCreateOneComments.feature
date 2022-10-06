Feature: Create one comments

  Background: Environment is set
    Given BASE_URL is set to "https://gorest.co.in/public/v1"
    And usersEndpoint is set to "/users"
    And postsEndpoint is set to "/posts"
    And commentsEndpoint is set to "/comments"
    And bearerToken is set to "3c2333def57e12a588eb567a9877a0bf629a6bc7e977432385b8d391445a689e"

  @comments-001
  Scenario: Post one comment within valid json
    Given set path to {{BASE_URL}}{{commentEndpoint}}
    And set request body to JSON data
    When click send button
    Then API should return 201 Created
    And API should return body JSON

  @comments-002
  Scenario: POST one comment within invalid json without id
    Given set path to {{BASE_URL}}{{commentEndpoint}}
    And set request body to JSON data
    When click send button
    Then API should return 201 Created
    And response body should contains same post_id
    And assert response body to json schema

  @comments-003
  Scenario: POST one comment within invalid json without post_id
    Given set path to {{BASE_URL}}{{commentEndpoint}}
    And set request body to JSON data
    When click send button
    Then API should return 422 Unprocessable Entity
    And response body should contains "must exist"
    And assert response body to json schema

  @comments-004
  Scenario: POST one comment within invalid json without name
    Given set path to {{BASE_URL}}{{commentEndpoint}}
    And set request body to JSON data
    When click send button
    Then API should return 422 Unprocessable Entity
    And response body should contains "can't be blank"
    And assert response body to json schema

  @comments-005
  Scenario: POST one comment within invalid json without email
    Given set path to {{BASE_URL}}{{commentEndpoint}}
    And set request body to JSON data
    And click send button
    Then API should return 422 Unprocessable Entity
    And response body should contains "can't be blank, is invalid"
    And assert response body to json schema"

  @comments-006
  Scenario: POST one comment within invalid json without body
    Given set path to {{BASE_URL}}{{commentEndpoint}}
    And set request body to JSON data
    When click send button
    Then API should return 422 Unprocessable Entity
    And response body should contains "can't be blank"
    And assert response body to json schema"

  @comments-007
  Scenario: POST one comment without null json
    Given set path to {{BASE_URL}}{{commentEndpoint}}
    And set request body to JSON data
    When click send button
    Then API should return 422 Unprocessable Entity
    And response body should contains ""must exist""
    And assert response body to json schema"


