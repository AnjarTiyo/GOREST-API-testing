Feature: Create a user post
  Background:
    Given set path post new user to "https://gorest.co.in/public/v1/users"
    And set request body post to json data
    When send request post create new user
    Then API should return 201
#      And post create new user json schema
    And API send usersID to dynamic variable
    And assert usersID not 0

  @positive @posts-001
  Scenario: POST create a user post with valid user ID and valid body
    Given set path to "https://gorest.co.in/public/v1/users/{id}/posts" with valid usersID
    And set request body to valid posts JSON data
    When send request POST create posts
    Then API should return 201
#    And assert response body to json schema "postCreatePosts.json"
    And API send postsID to dynamic variable
    And assert postsId not 0

  @negative @posts-002
  Scenario: POST create a user post with valid user ID and invalid body
    Given set path to "https://gorest.co.in/public/v1/users/{id}/posts" with valid usersID
    And set request body to invalid posts JSON data
    When send request POST create posts
    Then API should return 422

  @negative @posts-003
  Scenario: POST create a user post with valid user ID without body
    Given set path to "https://gorest.co.in/public/v1/users/{id}/posts" with valid usersID
    When send request POST create posts
    Then API should return 422

  @negative @posts-004
  Scenario: POST create a user post with invalid user ID
    Given set path to "https://gorest.co.in/public/v1/users/aa/posts" with invalid usersID
    When send request POST create posts invalid users
    Then API should return 422

