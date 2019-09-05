Feature: ChargeBack Complete flow

  Scenario Outline: Verify 'Payment Status' is Paid and 'Record Type' is Payment then 'Adjustment','Chargeback' and 'Refund' button is visible

    Given I login to Salesforce URL
    When I click on Contacts tag
    And I click on Recently Viewed dropdown Select List View
    And I select "All Contacts" from the list view
    And I type the contact "David Dash" in the Search box and press Enter to view the particular contact detail
    And I click on the searched contact name
    And I click the Opportunities button
    And I click on Opportunities name new oppy for rd link
    And I click on "Related" Tab
    And I click on Payment
    And I click "Chargeback" radio button
    And I provide values in Chargeback Bank Action,Chargeback Received On,Chargeback Reference Number,Chargeback Response By,Chargeback Actual Response Date,Chargeback SST Response and Chargeback Bank Final Notification Date fields
      | Chargeback Bank Action   | Chargeback Received On   | Chargeback Reference Number   | Chargeback Response By   | Chargeback Actual Response Date   | Chargeback SST Response   | Chargeback Bank Final Notification Date   |
      | <Chargeback Bank Action> | <Chargeback Received On> | <Chargeback Reference Number> | <Chargeback Response By> | <Chargeback Actual Response Date> | <Chargeback SST Response> | <Chargeback Bank Final Notification Date> |
#    And I click on Save button
    And I select on Chargeback's "Save" button
    Then I verify message "Error<new_line>Chargeback Received On Date needs to be greater than or equal to Payment Date." generated


    Examples:
      | Chargeback Bank Action | Chargeback Received On | Chargeback Reference Number | Chargeback Response By | Chargeback Actual Response Date | Chargeback SST Response | Chargeback Bank Final Notification Date |
      | Chargeback cancelled   | 2019-08-07             | CN100102                    | 2019-08-27             | 2019-08-27                      | Evidence provided       | 2019-08-27                              |