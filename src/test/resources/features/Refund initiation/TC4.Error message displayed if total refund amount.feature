Feature: Error message displayed if total refund amount less than the individual GAU amount
  As a Salesforce user, login to Salesforce and Error message displayed if total refund amount less than the individual GAU amount

  Scenario Outline: Verify Payment records under Opportunity after 'Refund Created'
    Given I login to Salesforce URL
    When I click on Contacts tag
    And I click on Recently Viewed dropdown Select List View
    And I select "All Contacts" from the list view
    And I type the contact "Aidan Le Gras" in the Search box and press Enter to view the particular contact detail
    And I click on the searched contact name
    And I click Opportunities button
    And I click on OPPORTUNITY NAME Aidan Le Gras RC-00001 Donation
    And I click on "Related" Tab
    And I click on Payment
    #And I click on Paid CheckBox
    #And I select Payment Date from payment date 2019-08-27
    #And I click on Save btn
    And I click Refund radio button under Payment Type
    And I provide field as Case Origin,Refund Type,Refund Amount,Refund Instrument,Bank Account No and Bank BSB
      | Case Origin   | Refund Type   | Refund Instrument  |Refund Amount | Bank Account No | Bank BSB |
      | <Case Origin> | <Refund Type> | <Refund Instrument> | <Refund Amount> | <Bank Account No> | <Bank BSB> |
    And I scroll up to page
    And I enter amount in the GAU under Manual Refund
    And click the GAU
    And I scroll down to page
    And I Save details
    Then I varify Error The requested Refund Amount should be equal to the total amount allocated against the campaigns/products
    Examples:
      | Case Origin   | Refund Type | Refund Amount  | Refund Instrument   | Bank Account No | Bank BSB |
      | Direct Mail   | Partial     | 250 | Bank Deposit     | 1782236         | 123456   |
