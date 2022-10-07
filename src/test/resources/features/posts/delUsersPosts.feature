Feature: Delete users posts
  Background:
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

  @posts-022
  Scenario: DEL user posts by valid post ID
    Given set path to "https://gorest.co.in/public/v1/posts/{id}" for single post
    When send request DEL single posts from id "postsID"
    Then API should return 204

  @posts-023
  Scenario: DEL user posts by invalid post ID
    Given set path to "https://gorest.co.in/public/v1/posts/aa" for delete invalid postID
    When send request DEL single posts from invalid "aa"
    Then API should return 404
    And assert response body "message" contains "Resource not found"