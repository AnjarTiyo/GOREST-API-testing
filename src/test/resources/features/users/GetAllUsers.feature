Feature: Retrieves all users
  Background: Environment is set
    Given bearerToken is set to "3c2333def57e12a588eb567a9877a0bf629a6bc7e977432385b8d391445a689e"

  @positive @users-004
  Scenario: get all users without parameter
    Given set path get all to "https://gorest.co.in/public/v1/users"
    When send request get all users
    Then should return 200 ok
    And response body page should be 1
    And get all user json schema

  @positive @users-005
  Scenario Outline: get all users with parameter page
    Given set path to "https://gorest.co.in/public/v1/users?page={page}" on "page" "<page>"
    When send request get all users
    Then should return 200 ok
    And response body page should be <page>
    And get all user with parameter page json schema
    Examples:
    |page|
    | 2 |
    |50 |

  @negative @users-006
  Scenario Outline: get all users with invalid string parameter page
    Given set path invalid to "https://gorest.co.in/public/v1/users?page={page}" on "page" "<page>"
    When send request get all users
    Then should return 400 bad request
    Examples:
    |page|
    |abc |
    |p   |

  @negative @users-007
  Scenario Outline: get all users with invalid special char parameter page
    Given set path invalid to "https://gorest.co.in/public/v1/users?page={page}" on "page" "<page>"
    When send request get all users
    Then should return 400 bad request
    Examples:
      |page|
      |??? |
      |@   |

  @negative @users-008
  Scenario Outline: get all users with invalid parameter gender
    Given set path invalid to "https://gorest.co.in/public/v1/users?gender={gender}" on "gender" "<gender>"
    When send request get all users
    Then should return 200 ok
    And get all user with invalid gender json schema
    Examples:
      |gender|
      |???   |
      |trans |
