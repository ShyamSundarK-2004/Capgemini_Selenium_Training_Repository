Feature: Login

  Scenario: navigate to ninja crm add a campaign name and create the campaign and verify the name added
    Given launching the browser
    And Navigate to ninja crm
    When enter the username and password
    And click on login button
    When click on campaign module
    And click on create campaign button
    When enter the campaign name
    And click on create campaign button
    Then verify the popup alert
    And logout from the application
