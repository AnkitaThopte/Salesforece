Feature: (Negative Scenario) Complete Allocation should display in refund form when it is there
  As a Salesforce user, login to Salesforce and Complete Allocation should display in refund form when it is there

  Scenario Outline: Complete Allocation should display in refund form when it is there
    Given I login to Salesforce URL
    When I click on Contacts tag
    And I click on Recently Viewed dropdown Select List View
    And I select "All Contacts" from the list view
    And I type the contact "Alisa James" in the Search box and press Enter to view the particular contact detail
    And I click on the searched contact name
    And I click Opportunities button
    And I click on OPPORTUNITY NAME Alisa James CG999889 Donation
    And I click on "Related" Tab
    And I click on Payment
  #  And I click on Paid CheckBox
   # And I select Payment Date from payment date 2019-08-28
   # And I click on Save btn
    And I click Refund radio button under Payment Type
    And I give details as Refund Type
      | Refund Type   |
      | <Refund Type> |
    Then I verify GAUs allocation is available as Campaign Name-Amount

    Examples:
     | Refund Type   |
     |  Partial      |
