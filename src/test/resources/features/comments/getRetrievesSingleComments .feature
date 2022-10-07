Feature: Retrieves single comments

  Background: Environment is set
#    Given BASE_URL is set to "https://gorest.co.in/public/v1"
#    And usersEndpoint is set to "/users"
#    And postsEndpoint is set to "/posts"
#    And commentsEndpoint is set to "/comments"
#    And bearerToken is set to "3c2333def57e12a588eb567a9877a0bf629a6bc7e977432385b8d391445a689e"

  @comments-016
  Scenario: GET all single comments within valid id
  Given set path to get retrieves all comment "https://gorest.co.in/public/v1/comments?id=50"
  When send request GET comments
  Then API should return 200 OK
#  And assert response GET all single comments within valid id to json schema

  @comments-017
  Scenario: GET all single comments within invalid id
  Given set path to get retrieves all comment "https://gorest.co.in/public/v1/comments?id=-5"
  When send request GET comments
  Then API should return 400 Not Found
#  And assert response body to json schema

