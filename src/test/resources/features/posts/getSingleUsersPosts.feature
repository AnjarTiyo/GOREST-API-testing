Feature: Retrieves single post
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

  @posts-012
  Scenario: GET posted post by using valid post ID
    Given set path to "https://gorest.co.in/public/v1/posts/{id}" for single post
    When send request GET single posts from id "postsID"
    Then API should return 200
#    And assert response body to json schema "getSinglePosts.json"
  @posts-013
  Scenario: GET posted post by using invalid post ID
    Given set path to "https://gorest.co.in/public/v1/posts/aa" for invalid id
    When send request GET single posts from invalid id "aa"
    Then API should return 404

  @posts-014
  Scenario: GET posted post by using valid user's ID
    Given set path to "https://gorest.co.in/public/v1/users/{id}/posts" for users post
    When send request GET single posts from id "usersID"
    Then API should return 200
#    And assert response body to json schema "getSinglePosts.json"

  @posts-015
  Scenario: GET posted post by using valid user's ID but never post
    Given set path to "https://gorest.co.in/public/v1/users/2/posts" for users never post
    When send request GET single posts from id "2"
    Then API should return 200
#    And assert response body to json schema "getSinglePosts.json"

  @posts-016
  Scenario: GET posted post by using invalid user's ID
    Given set path to "https://gorest.co.in/public/v1/users/aa/posts" for invalid id
    When send request GET single posts from invalid id "aa"
    Then API should return 404