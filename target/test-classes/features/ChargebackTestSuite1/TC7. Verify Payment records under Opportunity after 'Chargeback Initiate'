Feature: Verify Payment records under Opportunity chargeback initiated
  As a Salesforce user, login to Salesforce and Searching Payment Records with Chargeback Request

  Scenario Outline: Verify Payment records under Opportunity after 'Chargeback Initiate'
    Given I login to Salesforce URL
    When I click on Contacts tag
    And I click on Recently Viewed dropdown Select List View
    And I select "All Contacts" from the list view
    And I type the contact "Alannah Matheson" in the Search box and press Enter to view the particular contact detail
    And I click on the searched contact name
    And I click Opportunities button
    And I click on OPPORTUNITY NAME Alannah Matheson RC-00001 Donation
    And I click on "Related" Tab
    And I click on Payment
    And I click on Paid CheckBox
    And I select Payment Date from payment date 2019-08-28
    And I click on Save btn
    And I click Chargeback radio button under Payment Type
    And I provide value in field Chargeback Bank Action,Chargeback Received On and Chargeback Reference Number
      | Chargeback Bank Action   | Chargeback Received On   | Chargeback Reference Number   |
      | <Chargeback Bank Action> | <Chargeback Received On> | <Chargeback Reference Number> |
    And I Save details
    And I click on Opportunity Name Alannah Matheson RC-00001 Donation under Details tab
    And I click Payments link
    And I click on Payment Number
    And I scroll down to page
    Then I verify Payment records successfully created under Chargeback Information which are Chargeback Bank Action,Chargeback Received On and Chargeback Reference Number
      | Chargeback Bank Action   | Chargeback Received On   | Chargeback Reference Number   |
      | <Chargeback Bank Action> | <Chargeback Received On> | <Chargeback Reference Number> |

    Examples:
      | Chargeback Bank Action | Chargeback Received On | Chargeback Reference Number |
      | Chargeback initiated   | 2019-08-30             | CN100102                    |

