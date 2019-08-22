Feature: Verify Refund completion Date should be updated after the review
  As a Salesforce user, login to Salesforce and Review Refund Approval Date

  Scenario Outline: Refund Approval Date should be updated after the review
    Given I login to Salesforce URL
    When I clicked on Cases Tab
    And I type the case number "00001341" in the Search box and press Enter to view the particular case detail
    And I click on the searched case number
    And I scroll down to page
    And I click Refund Payment Link
   # And I scroll down to page
    Then I verify Refund Decision Date is display
      | Refund Completion Date |
      |<Refund Completion Date>|

    Examples:
      |Refund Completion Date |
      |  2019-08-21           |