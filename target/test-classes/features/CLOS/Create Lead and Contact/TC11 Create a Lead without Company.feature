# new feature
# Tags: optional
    
Feature: Verify Create a Lead without Company name
  As a Salesforce user, login to Salesforce and Create a new Lead with mandatory fields

  Scenario Outline: Verify Create a new Lead with mandatory fields
 # Scenario:  Verify Create a new Lead
    Given I login to Salesforce URL
    When I click on Leads tag
    And I click New button on right hand side of the page
    And I select Commercial Real Estate Lending as a record type
    And I click the Next button
    And I provide values in Website, CIN, Group, Email, Annual Revenue, Ownership, Lead Status, Last Name and Expected Date
      |Company | Website | CIN | Group | Email | Annual Revenue | Ownership | Lead Status | Last Name | Expected Date |
      | <Company> | <Website> | <CIN> |<Group> | <Email> | <Annual Revenue> | <Ownership> | <Lead Status> | <Last Name> | <Expected Date> |
    And I click on Save button
    Then I verify Error messsage "These required fields must be completed: Company"

    Examples:
      |Company | Website  | CIN | Group | Email | Annual Revenue | Ownership | Lead Status | Last Name | Expected Date |
      | SSAP Company  | www.aelon.com | 742252874666  | Group AAC  | supportserv@gmail.com | 600000000 | Private | Working - Contacted | Liam | 15/1/2020 |