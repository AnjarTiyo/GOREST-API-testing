Feature: Delete comments



Feature: Delete users posts
#  Background: Environment is set
#    Given set path post new user to "https://gorest.co.in/public/v1/users"
#    And set request body post to json data
#    When send request post create new user
#    Then API should return 201
#    And API send usersID to dynamic variable
#    And assert usersID not 0
#    Given set path to "https://gorest.co.in/public/v1/users/{id}/posts" with valid usersID
#    And set request body to valid posts JSON data
#    When send request POST create posts
#    Then API should return 201
#    And API send postsID to dynamic variable
#    And assert postsId not 0

  @comments-020
  Scenario: DEL one comment with valid id
    Given set path to "https://gorest.co.in/public/v1/comments/1951"
    When send request DEL comments
    Then API should return 204 No Content
#    And assert response body to json schema

  @comments-021
  Scenario: DEL one comment with inivalid id
  Given set path to "https://gorest.co.in/public/v1/comments/&*("
  When send request DEL comments
  Then API should return 204 No Content
  And assert response body to json schema