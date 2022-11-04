

@credentials
Feature: Login

  #Login Negative Tests


  Scenario: Login Correct Username Wrong Password
    Given The employee is on the login page
    When The employee types in g8tor into the username input
    When The employee types in chomp!! into the password input
    When The employee clicks on the login button
    Then The employee should see an alert saying they have the wrong password


  Scenario: Login Wrong Username Right Password
    Given The employee is on the login page
    When The employee types in g8tors into the username input
    When The employee types in chomp! into the password input
    When The employee clicks on the login button
    Then The employee should see an alert saying no user with that username found

  #Login Positive Tests


  Scenario: Login Correct Username Right Password
    Given The employee is on the login page
    When The employee types in g8tor into the username input
    When The employee types in chomp! into the password input
    When The employee clicks on the login button
    Then The employee should be able to login


  Scenario: Login Wrong Username Wrong Password
    Given The employee is on the login page
    When The employee types in g8tors! into the username input
    When The employee types in chomp!! into the password input
    When The employee clicks on the login button
    Then The employee should see an alert saying no user with that username found