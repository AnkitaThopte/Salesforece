Feature: Change of Relationship Manager by HV Co-ordinator.

  Scenario Outline: Change Relationship Manager by HV Co-ordinator

    Given I login to Salesforce URL
    When I click on Contacts tagg
    And I click on Recently Viewed dropdown Select List View
    And I select "All Contacts" from the list view
    And I type the contact "Oxfam Australia" in the Search box and press Enter to view the particular contact detail
    And I click on the searched contact name
    And I click on "Details" Tab
    And I scroll down to page
    And I click "Edit Relationship Manager" button
    And I enter "Bheem Kattikar" in Relationship Manager filed
    And I click on Save button
    Then I verify the Relationship Manager is now updated with new manager name
       | Manager Name |
       | <Manager Name> |
    Examples:
      | Manager Name |
      | Test User |
