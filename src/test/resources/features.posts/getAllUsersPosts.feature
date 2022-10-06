Feature: Retreives all user posts
  Background: Environment is set
    Given bearerToken is set to "3c2333def57e12a588eb567a9877a0bf629a6bc7e977432385b8d391445a689e"

  @positive @posts-005
  Scenario: GET all users post
    Given set path to "https://gorest.co.in/public/v1/posts"
    When send request GET posts
    Then API should return 200
    And assert response body to json schema "getAllPosts.json"

  @posts-006
  Scenario: GET all users posts with different pagination limit
    Given set path to "https://gorest.co.in/public/v1/posts"
    And set Header keys "X-Pagination-Limit" values to 20
    When send request GET posts
    Then API should return 200
    And assert response body to json schema "getAllPosts.json"
    And assert response body "limit" equals 20

  @posts-007
  Scenario: GET all users post with title contains "auxilium"
    Given set path to "https://gorest.co.in/public/v1/posts?title=auxilium"
    When send request GET posts
    Then API should return 200
    And assert response body to json schema "getAllPosts.json"
    And assert response body "title" contains "auxilium"

  @posts-008
  Scenario: GET all users post with body contains "auxilium"
    Given set path to "https://gorest.co.in/public/v1/posts?body=auxilium"
    When send request GET posts
    Then API should return 200
    And assert response body to json schema "getAllPosts.json"
    And assert response body "body" contains "auxilium"

  @negative @posts-009
  Scenario: GET all users post with body contains non existence word
    Given set path to "https://gorest.co.in/public/v1/posts?title=@#$%"
    When send request GET posts
    Then API should return 204
    And assert response body to json schema "getAllPosts.json"

  @posts-010
  Scenario Outline: GET all users post within valid page
    Given set path to "https://gorest.co.in/public/v1/posts?page={page}" on "page" "<page>"
    When send request GET posts
    Then API should return 200
    And assert response body to json schema "getAllPosts.json"
    And assert response body "page" equals <page>
    Examples:
    |page|
    |5|
    |1 |
    |2 |


  @posts-011
  Scenario Outline: GET all users post within invalid page
    Given set path to "https://gorest.co.in/public/v1/posts?page={page}" on "page" "<page>"
    When send request GET posts
    Then API should return 400
    And assert response body to json schema "getAllPosts.json"
    And assert response body "page" equals <page>
    Examples:
    |page|
    |200 |
    |aa  |
    |@#  |

