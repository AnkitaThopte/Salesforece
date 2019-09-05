Feature: ChargeBack Complete flow

  Scenario Outline: Verify 'Payment Status' is Paid and 'Record Type' is Payment then 'Adjustment','Chargeback' and 'Refund' button is visible

    Given I login to Salesforce URL
    When I click on Contacts tag
    And I click on Recently Viewed dropdown Select List View
    And I select "All Contacts" from the list view
    And I type the contact "Samaira" in the Search box and press Enter to view the particular contact detail
    And I click on the searched contact name
    And I click the Opportunities button
    And I click on Opportunities name test active opportunity link
    And I click on "Related" Tab
    And I click on Payment
#    And I click on Paid CheckBox
#    And I select Payment Date from payment date
#    And I click on Save button
    And I click "Chargeback" radio button
    And I provide details Chargeback Bank Action,Chargeback Received On and Chargeback Reference Number
      | Chargeback Bank Action | Chargeback Received On | Chargeback Reference Number |
      | <Chargeback Bank Action> | <Chargeback Received On> | <Chargeback Reference Number> |
    And I select on Chargeback's "Save" button
    Then I verify message "Success /n Chargeback has been initiated and is in progress." generated
    Then I Verify Related Payment Record generated

  Examples:
    | Chargeback Bank Action | Chargeback Received On | Chargeback Reference Number |
    | Chargeback initiated | 2019-08-27 | CN100102 |