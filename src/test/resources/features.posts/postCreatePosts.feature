Feature: Create a user post

#  Background: Environment is set
    Given bearerToken is set to "10d553d5ddff8744213fde67295563f6ac0a2d296b96f29ad004aa92bdd5ce2b"

  @positive @posts-001
  Scenario: POST create a user post with valid user ID and valid body
    Given set path to "https://gorest.co.in/public/v1/users/13/posts" with valid usersID
    And set request body to valid posts JSON data
    When send request POST create posts
    Then API should return 201
#    And assert response body to json schema "postCreatePosts.json"
    And API send id to dynamic variable

  @negative @posts-002
  Scenario: POST create a user post with valid user ID and invalid body
    Given set path to "BASE_URL"+"usersEndpoint"+"usersID"+"postsEndpoint"
    And set request body to invalid posts JSON data
    When send request POST create posts
    Then API should return 200
    And assert response body to json schema "postCreatePostsInvalidJSON.json"

  @negative @posts-003
  Scenario: POST create a user post with valid user ID without body
  @negative @posts-004
  Scenario: POST create a user post with invalid user ID