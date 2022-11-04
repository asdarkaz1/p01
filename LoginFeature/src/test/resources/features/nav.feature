@nav
Feature: Navigation


    Scenario: Home Page Links Visible
      Given The manager is logged in as a manager
      Then The manager should see links for Matrices, Test Cases, Defect Reporting and Defect Overview

  Scenario: Back Navigation
      Given The manager is logged in as a manager
      When The manager clicks on Matrices
      Then The header of the page should be Matrices
      When The manager clicks the browser back button
      Then The manager should be on the home page and the title of page is Home
      When The manager clicks on Test Cases
      When The manager clicks the browser back button
      Then The manager should be on the home page and the title of page is Home


  Scenario: All Links Viable
    Given The manager is logged in as a manager
    When The manager clicks on Matrices
    Then The title of page should be Matrix Overview
    When The manager clicks on Test Cases
    Then The title of page should be Test Case Overview
    When The manager clicks on Defect Overview
    Then The title of page should be Defect Overview
    When The manager clicks on Report a Defect
    Then The title of page should be Defect Reporter

