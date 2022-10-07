Feature: Put update comments

  @comments-018
  Scenario: PUT one comment within valid json
  Given set path to PUT one comment "https://gorest.co.in/public/v1/posts/2/comments/"
  And set request body PUT one comment to JSON data
  When send request PUT comments
  And API should return 200 OK for comment update