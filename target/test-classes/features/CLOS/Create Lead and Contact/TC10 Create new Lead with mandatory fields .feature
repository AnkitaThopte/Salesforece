# new feature
# Tags: optional
    
Feature: Verify Create a new Lead with mandatory fields
  As a Salesforce user, login to Salesforce and Create a new Lead

  Scenario Outline: Verify Create a new Lead
 # Scenario:  Verify Create a new Lead
    Given I login to Salesforce URL
    When I click on Leads tag
    And I click New button on right hand side of the page
    And I select Commercial Real Estate Lending as a record type
    And I click the Next button
    And I provide values in Company, Website, CIN, Group, Email, Annual Revenue, Ownership, Lead Status, Last Name and Expected Date
      |Company | Website | CIN | Group | Email | Annual Revenue | Ownership | Lead Status | Last Name | Expected Date |
      | <Company> | <Website> | <CIN> |<Group> | <Email> | <Annual Revenue> | <Ownership> | <Lead Status> | <Last Name> | <Expected Date> |
    And I click on Save button
    And I again click Leads tab
    And I type the leads "Messie" in the Search box and press Enter to view the particular contact detail
    And I click on the searched lead name
    Then I verify Lead is successfully created with Company, Website, CIN, Group, Email, Annual Revenue, Ownership, Lead Status, Last Name and Expected Date

  Examples:
        |Company | Website  | CIN | Group | Email | Annual Revenue | Ownership | Lead Status | Last Name | Expected Date |
        | SSP Company  | www.melon.com | 742252874666  | Group AAC  | supportserv@gmail.com | 600000000 | Private | Open-Not Contacted | Messie | 15/1/2020 |