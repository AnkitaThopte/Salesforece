Feature: Verify Payment records under Opportunity Refund initiated
  As a Salesforce user, login to Salesforce and Searching Payment Records with Refund Request

  Scenario Outline: Verify Payment records under Opportunity after 'Refund Created'
    Given I login to Salesforce URL
    When I click on Contacts tag
    And I click on Recently Viewed dropdown Select List View
    And I select "All Contacts" from the list view
    And I type the contact "Aidan Le Gras" in the Search box and press Enter to view the particular contact detail
    And I click on the searched contact name
    And I click Opportunities button
    And I click on OPPORTUNITY NAME Aidan Le Gras CAMPFL00002 Donation
    And I click on "Related" Tab
    And I click on Payment
    And I click on Paid CheckBox
    And I select Payment Date from payment date 2019-08-27
    And I click on Save btn
    And I click Refund radio button under Payment Type
    And I provide fields as Case Origin,Refund Type,Refund Instrument,Bank Account No and Bank BSB
      | Case Origin   | Refund Type   | Refund Instrument   | Bank Account No | Bank BSB |
      | <Case Origin> | <Refund Type> | <Refund Instrument> | <Bank Account No> | <Bank BSB> |
    And I Save details
    And I scroll up to page
   # And I click on Opportunity Name sally den CAMP00001 Donation under Details tab
    #And I click Payments link
    #And I click on Payment Number
    #And I scroll down to page
    Then I verify message "Success Refund process initiated"

    Examples:
      | Case Origin   | Refund Type   | Refund Instrument   | Bank Account No | Bank BSB |
      | Direct Mail   | Full             | Bank Deposit     | 1782236         | 123456   |
