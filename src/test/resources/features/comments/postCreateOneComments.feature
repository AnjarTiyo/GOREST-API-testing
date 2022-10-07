Feature: Create one comment

  Background: new UsersID and PostsID generated
    Given set path post new user to "https://gorest.co.in/public/v1/users"
    And set request body post to json data
    When send request post create new user
    Then API should return 201
    And API send usersID to dynamic variable
    And assert usersID not 0
    Given set path to "https://gorest.co.in/public/v1/users/{id}/posts" with valid usersID
    And set request body to valid posts JSON data
    When send request POST create posts
    Then API should return 201
    And API send postsID to dynamic variable
    And assert postsId not 0

  @comments-001
  Scenario: Post one comment within valid json
    Given set path to Post one comment "https://gorest.co.in/public/v1/posts/{postsID}/comments"
    And set request body to JSON data
    When send request POST comments
    Then API should return 201 Created
#    And API should return body JSON

  @comments-002
  Scenario: POST one comment within invalid json without id
    Given set path to Post one comment "https://gorest.co.in/public/v1/comments"
    And set request body to JSON data
    When send request POST comments
    Then API should return 201 Created
#    And response body should contains same post_id
#    And assert response body to json schema

  @comments-003
  Scenario: POST one comment within invalid json without post_id
    Given set path to Post one comment "https://gorest.co.in/public/v1/comments"
    And set request body to JSON data
    When send request POST comments
    Then API should return 422
#    And response body should contains "must exist"
#    And assert response body to json schema

  @comments-004
  Scenario: POST one comment within invalid json without name
    Given set path to Post one comment "https://gorest.co.in/public/v1/comments"
    And set request body to JSON data
    When send request POST comments
    Then API should return 422
#    And response body should contains "can't be blank"
#    And assert response body to json schema

  @comments-005
  Scenario: POST one comment within invalid json without email
    Given set path to Post one comment "https://gorest.co.in/public/v1/comments"
    And set request body to JSON data
    And send request POST comments
    Then API should return 422
#    And response body should contains "can't be blank, is invalid"
#    And assert response body to json schema

  @comments-006
  Scenario: POST one comment within invalid json without body
    Given set path to Post one comment "https://gorest.co.in/public/v1/comments"
    And set request body to JSON data
    When send request POST comments
    Then API should return 422
#    And response body should contains "can't be blank"
#    And assert response body to json schema

  @comments-007
  Scenario: POST one comment without null json
    Given set path to Post one comment "https://gorest.co.in/public/v1/comments"
    And set request body to JSON data
    When send request POST comments
    Then API should return 422
#    And response body should contains ""must exist""
#    And assert response body to json schema


