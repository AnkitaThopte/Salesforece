# new feature
# Tags: optional
    
Feature: Verify Create a new Lead
  As a Salesforce user, login to Salesforce and Create a new Lead

  Scenario Outline: Verify Create a new Lead
 # Scenario:  Verify Create a new Lead
    Given I login to Salesforce URL
    When I click on Leads tag
    And I click New button on right hand side of the page
     And I select Commercial Real Estate Lending as a record type
        And I click the Next button
    And I provide Company, Website, CIN, Group, Email, Annual Revenue, Ownership, Lead Status, First Name, Last Name, Date of Incorporation, Street, City, Country, Loan Application Name, Amount, Loan Purpose and Expected Date
      |Company | Website | CIN | Group | Email | Annual Revenue | Ownership | Lead Status | First Name  |Last Name | Date of Incorporation |Street | City | Country | Loan Application Name | Amount | Loan Purpose |Expected Date |
      | <Company> | <Website> | <CIN> |<Group> | <Email> | <Annual Revenue> | <Ownership> | <Lead Status> | <First Name>| <Last Name> | <Date of Incorporation> | <Street> | <City> | <Country> | <Loan Application Name>| <Amount> |<Loan Purpose>|<Expected Date> |
    And I click on Save button
    And I again click Leads tab
    And I type the leads "Liam" in the Search box and press Enter to view the particular contact detail
    And I click on the searched lead name
    Then I verified Lead is successfully created with Company, Website, CIN, Group, Email, Annual Revenue, Ownership, Lead Status, First Name, Last Name, Date of Incorporation, Street, City, Country, Loan Application Name, Amount, Loan Purpose and Expected Date

    Examples:
      |Company | Website  | CIN | Group | Email | Annual Revenue | Ownership | Lead Status | First Name |Last Name | Date of Incorporation | Street | City | Country | Loan Application Name | Amount | Loan Purpose | Expected Date |
      | SSAP Company  | www.aelon.com | 742252874666  | Group AAC  | supportserv@gmail.com | 600000000 | Private | Working - Contacted | Payne |Liam | 15/1/2020| High Street| Pune | India | Personal Loan | 2000000 | Refinance Loan | 15/1/2020 |