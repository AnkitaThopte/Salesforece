# new feature
# Tags: optional
    
Feature: Convert Lead into Opportunity with new contact
  As a Salesforce user, login to Salesforce and Create a new Lead with mandatory fields

  Scenario Outline: Verify Create a new Lead with mandatory fields
 # Scenario:  Verify Create a new Lead
    Given I login to Salesforce URL
    When I click on Leads tag
    And I type the leads "Amit Deshmukh" in the Search box and press Enter to view the particular contact detail
    And I click on the searched lead name
  #  And I click Convert Lead button on right hand side of the page
     And I click Convert Lead button
    And I Close this window page and click on Loan Proposals tab
    And I type the leads "Business Loan" in the Search box and press Enter to view the particular contact detail
   # And I click on the searched lead name
    And I again click Leads tab
    And I type the leads "Amit Deshmukh" in the Search box and press Enter to view the particular contact detail
    And I verify note as "No items to display."
    And I again click Loan Proposals tab
    And I type the leads "Business Loan" in the Search box and press Enter to view the particular contact detail
    Then I verify Lead is successfully converted to Loan proposal
    |Opportunity Name| Customer Group Name|
    |<Opportunity Name> | <Customer Group Name>|

    Examples:
    |Opportunity Name| Customer Group Name|
    | Business Loan  | DSKM  |
