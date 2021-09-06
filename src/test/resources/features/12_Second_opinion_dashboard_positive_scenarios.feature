Feature: Validate Second Opinion Dashboard
#User must click on the second opinion in home page and navigated to second opinion page
  Scenario: Validate that the user is able to login with valid credentials
    Given Launch application
    When Enter login data and login
   Then verify homepage

  Scenario: Validate that the user is able to click on the Second Opinion tab
    When clicks on the second opinion tab
    Then navigated to second opinion page

  Scenario: Validate that the user is able to click on Resume Cases and is navigated to uplaod scans page
    When clicks on Resume Cases
    Then navigated to switch to web alert


  Scenario: Validate that User is able to click on Requested tab
    When  clicks on the Requested tab
    Then  navigated to Requested page

  Scenario: Validate that User is able to click on Reviewed tab
    When  clicks on the Reviewed tab
    Then  navigated to Reviewed  page
