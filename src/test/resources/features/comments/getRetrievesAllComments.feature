Feature: Retrieves all comments

  Background: Environment is set
#    Given BASE_URL is set to "https://gorest.co.in/public/v1"
#    And usersEndpoint is set to "/users"
#    And postsEndpoint is set to "/posts"
#    And commentsEndpoint is set to "/comments"
#    And bearerToken is set to "3c2333def57e12a588eb567a9877a0bf629a6bc7e977432385b8d391445a689e"

  @comments-008
  Scenario: GET all comments
    Given set path to get retrieves all comment "https://gorest.co.in/public/v1/comments"
    When send request GET comments
    Then API should return 200 OK
    And assert response body to GET all comments json schema

  @comments-009
  Scenario: GET all  comments with invalid endpoint
    Given set path to get retrieves all comment "https://gorest.co.in/public/v1/comments1234"
    And send request GET comments
    Then API should return 404 Not Found

  @comments-010
  Scenario: GET all users comments with name contains "Chakravartee"
    Given set path to get retrieves all comment "https://gorest.co.in/public/v1/comments?name=Chakravartee"
    When send request GET comments
    Then API should return 200 OK
    And assert response GET all users comments with name to json schema

  @comments-011
  Scenario: GET all users comments with body contains "Nam"
    Given set path to get retrieves all comment "https://gorest.co.in/public/v1/comments?body=Nam"
    When send request GET comments
    Then API should return 200 OK
    And assert response GET all users comments with name to json schema

  @comments-012
  Scenario: GET all users comments with body contains number
    Given set path to get retrieves all comment "https://gorest.co.in/public/v1/comments?body=-12345"
    When send request GET comments
    Then API should return 200 OK
    And assert response GET all users comments with body contains number to json schema

  @comments-013
  Scenario: GET all users comments with body contains Special character
    Given set path to get retrieves all comment "https://gorest.co.in/public/v1/comments?body=#$%^&"
    When send request GET comments
    Then API should return 400 Not Found


  @comments-014
  Scenario: GET all users comments within valid page
    Given set path to get retrieves all comment "https://gorest.co.in/public/v1/comments?page=20"
    When send request GET comments
    Then API should return 200 OK
    And assert response GET all users comments within valid page to json schema

  @comments-015
  Scenario: GET all users comments within invalid page
  Given set path to get retrieves all comment "https://gorest.co.in/public/v1/comments?page=10000"
  When send request GET comments
  Then API should return 200 OK
  And assert response GET all users comments within invalid page to json schema