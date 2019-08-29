Feature: Verify account team make status of approval case as payment done
  As a Salesforce user, login to Salesforce and Searching Payment Records with Refund Request

  Scenario Outline: Verify account team make status of approval case as payment done

     Given I login to Salesforce URL
     When I clicked on Cases Tab
     And I click on Recently Viewed dropdown Select List View
     And I select "All Open Cases" under case tab
     And I type the case number "00001306" in the Search box and press Enter to view the particular case detail
     And I click on the searched case number
     And I click Edit Status under Case Information
     #And I click on Status
     And I select Payment Done under case information
     And I scroll down to page
     And I provide Payment Reference Number under Refund
        |Payment Reference Number|
        | <Payment Reference Number> |
     And I click Save under Refund Details form
     Then I verify refund Status is set as Payment Done

    Examples:
      |Payment Reference Number|
      | 415263 |

