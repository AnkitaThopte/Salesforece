Feature: Refunds & Adjustments - Searching Payment Records with Chargeback Request
  As a Salesforce user, login to Salesforce and Searching Payment Records with Chargeback Request


  Scenario Outline: Verify Payment status is Unpaid
    Given I login to Salesforce URL
    When I click on Contacts tag
    And I click on Recently Viewed dropdown Select List View
    And I select "All Contacts" from the list view
    And I type the contact "Aaron Tonna" in the Search box and press Enter to view the particular contact detail
    And I click on the searched contact name
    And I click Opportunities button
    And I click on OPPORTUNITY NAME Tonna Opportunity
    And I click on "Related" Tab
    And I click on Payment
    Then I verify Payment Status and Record Type
      | Payment Status | Record Type |
      | <Payment Status> | <Record Type> |
    Examples:
      | Payment Status | Record Type |
      | Paid | Payment |