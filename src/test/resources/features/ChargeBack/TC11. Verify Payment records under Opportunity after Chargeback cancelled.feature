Feature: Verify Payment records under Opportunity chargeback cancelled
  As a Salesforce user, login to Salesforce and Searching Payment Records with Chargeback Request

  Scenario Outline: Verify Payment records under Opportunity after 'Chargeback cancelled'
    Given I login to Salesforce URL
    When I click on Contacts tag
    And I click on Recently Viewed dropdown Select List View
    And I select "All Contacts" from the list view
    And I type the contact "Dennis Falcon" in the Search box and press Enter to view the particular contact detail
    And I click on the searched contact name
    And I click Opportunities button
    And I click on OPPORTUNITY NAME Dennis Falcon CG999889 Donation
    And I click on "Related" Tab
    And I click on Payment
    #And I click Chargeback radio button
    And I provide value in field Chargeback Bank Action,Chargeback Received On and Chargeback Reference Number
      | Chargeback Bank Action   | Chargeback Received On   | Chargeback Reference Number   |
      | <Chargeback Bank Action> | <Chargeback Received On> | <Chargeback Reference Number> |
    And I Save details
    And I click on Opportunity Name Dennis Falcon CG999889 Donation under Details tab
    And I click Payments link
    And I click on Payment Number
    And I scroll down to page
    Then I verify Payment records successfully created under Opportunity after Chargeback cancelled which are Chargeback Bank Action,Chargeback Received On and Chargeback Reference Number
      | Chargeback Bank Action   | Chargeback Received On   | Chargeback Reference Number   |
      | <Chargeback Bank Action> | <Chargeback Received On> | <Chargeback Reference Number> |


    Examples:
      | Chargeback Bank Action | Chargeback Received On | Chargeback Reference Number |
      | Chargeback cancelled  | 2019-08-30              | CN100103                    |