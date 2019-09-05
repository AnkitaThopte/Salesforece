Feature: ChargeBack Complete flow

  Scenario Outline: Verify 'Payment Status' is Paid and 'Record Type' is Payment then 'Adjustment','Chargeback' and 'Refund' button is visible

    Given I login to Salesforce URL
    When I click on Contacts tag
    And I click on Recently Viewed dropdown Select List View
    And I select "All Contacts" from the list view
    And I type the contact "Samaira" in the Search box and press Enter to view the particular contact detail
    And I click on the searched contact name
    And I click the Opportunities button
    And I click on Opportunities name Samaira Malhotra CAMP00001 Donation link
    And I click on "Related" Tab
    And I click on Payment
#    And I click on Paid CheckBox with click on Edit Paid option
#    And I select Payment Date from payment date 2019-08-27
#    And I click on Save button
#    And I click "Chargeback" radio button
    And I provide values in Chargeback Bank Action,Chargeback Received On,Chargeback Reference Number,Chargeback Response By,Chargeback Actual Response Date,Chargeback SST Response and Chargeback Bank Final Notification Date fields
      | Chargeback Bank Action | Chargeback Received On | Chargeback Reference Number | Chargeback Response By | Chargeback Actual Response Date | Chargeback SST Response | Chargeback Bank Final Notification Date |
      | <Chargeback Bank Action> | <Chargeback Received On> | <Chargeback Reference Number> | <Chargeback Response By> | <Chargeback Actual Response Date> | <Chargeback SST Response> | <Chargeback Bank Final Notification Date> |
    And I select on Chargeback's "Save" button
    Then I verify message "Success Chargeback updated successfully." generated
    And I scroll up to page
    And I click "Related" Tab under Payment
    And I click the required Payment under Payments(Related Payment Record) option
    Then I verify that 'Charegback Bank Action' is processed and 'Refund','Adjustment' and 'Chargeback' radio button should be visible and can create 'New Chargeback','Refund' or 'Adjustment

    Examples:
      | Chargeback Bank Action | Chargeback Received On | Chargeback Reference Number | Chargeback Response By | Chargeback Actual Response Date | Chargeback SST Response | Chargeback Bank Final Notification Date |
      | Chargeback processed | 2019-08-27 | CN100102 | 2019-08-27 | 2019-08-27 |  Evidence provided | 2019-08-27 |