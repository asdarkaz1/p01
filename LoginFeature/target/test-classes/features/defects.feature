@defect
Feature: Assign Defect


  Scenario: Assign Defect
    Given The manager is logged in as a manager
    Then The manager should see pending defects
    When The manager clicks on the select button for a defect
    Then The defect description should appear in bold
    When The manager selects an tester from the drop down
    When The manager clicks assign
    Then The defect should disappear from the list
    Given The assigned tester is on their home page
    Then The tester should see the pending defect

  Scenario: Change Status
    Given The tester is on the Home Page
    Then The tester can can see only defects assigned to them
    When The tester changes to defect to any status
    Then The tester should see the defect has a different status


  Scenario: Steps too short
    Given The employee is on the Defect Reporter Page
    When The employee selects todays date
    When The employee clicks on description box and types
            """
            Users are able to create multiple accounts using the same username but
            with a different password.
            """
    When The employee clicks on steps box and types
            """
            meh
            """
    When The employee selects high priority
    When The employee selects low severity
    When The employee clicks the report button
    Then No confirmation dialog appears

  Scenario: Description too short
    Given The employee is on the Defect Reporter Page
    When The employee selects todays date
    When The employee clicks on description box and short types
            """
            meh
            """
    When The employee clicks on steps box and long types
            """
            1. User creates a new account
            2. User reloads the new user page
            3. User creates an account with same username but different password
            """
    When The employee selects high priority
    When The employee selects low severity
    When The employee clicks the report button
    Then No confirmation dialog appears


  Scenario: No Date Selected
    Given The employee is on the Defect Reporter Page
    When The employee clicks on description box and types
            """
            Users are able to create multiple accounts using the same username but
            with a different password.
            """
    When The employee clicks on steps box and long types
            """
            1. User creates a new account
            2. User reloads the new user page
            3. User creates an account with same username but different password
            """
    When The employee selects high priority
    When The employee selects low severity
    When The employee clicks the report button
    Then No confirmation dialog appears





  Scenario: Report New Defect
    Given The employee is on the Defect Reporter Page
    When The employee selects todays date
    When The employee clicks on description box and types
            """
            Users are able to create multiple accounts using the same username but
            with a different password.
            """
    When The employee clicks on steps box and long types
            """
            1. User creates a new account
            2. User reloads the new user page
            3. User creates an account with same username but different password
            """
    When The employee selects high priority
    When The employee selects low severity
    When The employee clicks the report button
    Then There should be a confirmation box
    Then A modal should appear with a Defect ID
    When The employee clicks close
    Then The modal should disappear