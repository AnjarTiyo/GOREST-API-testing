Feature: Update users posts
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

  @posts-017
  Scenario: PUT update user post title and body with valid body by post ID
    Given set path to "https://gorest.co.in/public/v1/posts/{id}" for put update post
    And set request body to valid posts update JSON data
    When send request PUT update posts
    Then API should return 200
    And assert response body "title" contains "new title"

  @posts-018
  Scenario: PUT update user post title and body with valid body by invalid post ID
    Given set path to "https://gorest.co.in/public/v1/posts/aa" for put update post
    And set request body to valid posts update JSON data
    When send request PUT update posts from invalid id
    Then API should return 404

  @posts-019
  Scenario: PUT update user post title and body with invalid body by post ID
    Given set path to "https://gorest.co.in/public/v1/posts/{id}" for put update post
    And set request body to valid posts update JSON data
    When send request PUT update posts invalid body
    Then API should return 422

  @posts020
  Scenario: PUT update user post title and body without body by post ID
    Given set path to "https://gorest.co.in/public/v1/posts/{id}" for put update post
    When send request PUT update posts without body
    Then API should return 422

  @posts021
  Scenario: PATCH create new feature on user post by post ID
    Given set path to "https://gorest.co.in/public/v1/posts/{id}" for put update post
    And set request body to valid patch update JSON data
    When send request PATCH update posts
    Then API should return 200
    And assert response body "data" contains "new_feature"
