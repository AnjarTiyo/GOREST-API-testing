Feature: Retrieves all comments

  Background: Environment is set
    Given BASE_URL is set to "https://gorest.co.in/public/v1"
    And usersEndpoint is set to "/users"
    And postsEndpoint is set to "/posts"
    And commentsEndpoint is set to "/comments"
    And bearerToken is set to "3c2333def57e12a588eb567a9877a0bf629a6bc7e977432385b8d391445a689e"

  @comments-008
  Scenario: GET all comments
    Given set path to {{BASE_URL}}{{commentEndpoint}}
    When click Send button
    Then API should return 200 OK
    And assert response body to json schema

  @comments-009
  Scenario: GET all  comments with invalid endpoint
    Given set path to {{BASE_URL}}{{commentEndpoint123}}
    And click Send button
    Then API should return 404 Not Found
    And assert response body to json schema

  @comments-010
  Scenario: GET all users comments with name contains "Vasudeva Prajapat"
    Given set path to {{BASE_URL}}{{commentEndpoint}}?name=Vasudeva Prajapat
    When click Send button
    Then API should return 200 OK
    And assert response body to json schema

  @comments-011
  Scenario: GET all users comments with body contains "Nam deleniti earum"
    Given set path to {{BASE_URL}}{{commentEndpoint}}?body=Nam deleniti earum
    When click Send button
    Then API should return 200 OK
    And assert response body to json schema

  @comments-012
  Scenario: GET all users comments with body contains number
    Given set path to {{BASE_URL}}{{commentEndpoint}}?body=12345
    When click Send button
    Then API should return 400 Not Found
    And assert response body to json schema

  @comments-013
  Scenario: GET all users comments with body contains Special character
    Given set path to {{BASE_URL}}{{commentEndpoint}}?body=#$%^&
    When click Send button
    Then API should return 400 Not Found
    And assert response body to json schema

  @comments-014
  Scenario: GET all users comments within valid page
    Given set path to {{BASE_URL}}{{commentEndpoint}}?page=20
    When click Send button
    Then API should return 200 OK
    And assert response body to json schema

  @comments-015
  Scenario: GET all users comments within invalid page
  Given set path to {{BASE_URL}}{{commentEndpoint}}?page={page}
  When click Send button
  Then API should return 200 OK
  And assert response body to json schema