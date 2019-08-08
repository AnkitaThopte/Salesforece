Feature: Remove the Relationship Manager by HV Co-ordinator.

  Scenario Outline: Login to Salesforce URL and Remove Relationship Manager

    Given I login to Salesforce URL
    When I click on Contacts tag
    And I click on Recently Viewed dropdown Select List View
    And I select "All Contacts" from the list view
    And I type the contact "Oxfam Australia" in the Search box and press Enter to view the particular contact detail
    And I click on the searched contact name
    And I click on "Details" Tab
    And I scroll down to page
    And I click "Edit Relationship Manager" button

    And I click on the cross mark against the Relationship Manager name and remove it
    And I enter "Test User" in Relationship Manager filed

    And I click on Save button

    Then I verify the Previous Relationship Manager name is populated with previous value
      | Previous Relationship Manager |
      | <Previous Relationship Manager> |
    Examples:
      | Previous Relationship Manager |
      | Simon Vaughan |