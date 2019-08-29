Feature: Verify Payment records under Opportunity after chargeback processed
  As a Salesforce user, login to Salesforce and Searching Payment Records with Chargeback Request

  Scenario Outline: Verify Payment records under Opportunity after 'Chargeback processed'
    Given I login to Salesforce URL
    When I click on Contacts tag
    And I click on Recently Viewed dropdown Select List View
    And I select "All Contacts" from the list view
    And I type the contact "Andrew J Palmer" in the Search box and press Enter to view the particular contact detail
    And I click on the searched contact name
    And I click Opportunities button
    And I click on OPPORTUNITY NAME Andrew J Palmer 123 Donation
    And I click on "Related" Tab
    And I click on Payment
    #And I click Chargeback radio button
    And I provide values in Chargeback Bank Action,Chargeback Response By,Chargeback Actual Response Date,Chargeback SST Response and Chargeback Bank Final Notification Date
      |Chargeback Bank Action | Chargeback Response By | Chargeback Actual Response Date| Chargeback SST Response  | Chargeback Bank Final Notification Date |
      |<Chargeback Bank Action>| <Chargeback Response By> | <Chargeback Actual Response Date> | <Chargeback SST Response> | <Chargeback Bank Final Notification Date>|
    And I Save details
    And I click on Opportunity Name Andrew J Palmer 123 Donation under Details tab
    And I click Payments link
    And I click on Payment Number
    And I scroll down to page
    Then I verify Payment records successfully created under Chargeback Information after Chargeback Processed which are Chargeback Bank Action,Chargeback Response By,Chargeback Actual Response Date,Chargeback SST Response and Chargeback Bank Final Notification Date
      |Chargeback Bank Action | Chargeback Response By | Chargeback Actual Response Date| Chargeback SST Response  | Chargeback Bank Final Notification Date |
      |<Chargeback Bank Action>| <Chargeback Response By> | <Chargeback Actual Response Date> | <Chargeback SST Response> | <Chargeback Bank Final Notification Date>|

    Examples:
      |Chargeback Bank Action | Chargeback Response By | Chargeback Actual Response Date | Chargeback SST Response | Chargeback Bank Final Notification Date |
      | Chargeback processed  | 2019-08-30             | 2019-08-30                      |  Proceed with chargeback      | 2019-08-30           |

