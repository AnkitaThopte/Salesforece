Feature: To Create new supporter record and verify the details
  As a Salesforce user, login to Salesforce and create new Supporter and Verify
  the details

#      Need to verify on Dev environment
  Scenario Outline: Add feedback and complaints against a supporter record
    Given I login to Salesforce URL
    When I click on Contacts tag
    And I click on Recently Viewed dropdown Select List View
    And I select "All Contacts" from the list view
    And I type the contact "Willson" in the Search box and press Enter to view the particular contact detail
    And I click on the searched contact name
    And I click on "Activity" Tab
    And I click on New Task tab
    And I Provide the following details under New Task Page
     | Assigned to | Subject| Status| Priority |
     | <Assigned to> | <Subject> | <Status> | <Priority> |
    And I click on Save button
    And I click on Activity History subject

    Then I verify following details under Task
      | Assigned to | Subject| Status| Priority |
      | <Assigned to> | <Subject> | <Status> | <Priority> |
    Examples:
      | Assigned to | Subject | Status | Priority |
      | Suchi Nayak | Call | Completed | High |