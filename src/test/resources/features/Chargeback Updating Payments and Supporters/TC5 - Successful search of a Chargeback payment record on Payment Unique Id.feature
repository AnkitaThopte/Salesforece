Feature: Refunds & Adjustments - Searching Payment Records with Chargeback Request
  As a Salesforce user, login to Salesforce and Searching Payment Records with Chargeback Request


  Scenario Outline: Successful search of a Chargeback payment record on Payment Unique Id
    Given I login to Salesforce URL
    And I click on the searched salesforce textbox
    And I search for Payment Unique Id of an Chargeback record
      | Payment Unique Id |
      | <Payment Unique Id> |
    And I click on Payment Number on the searched record
    Then I verify the payment for Chargeback record
      | Payment Unique Id | Record Type |
      | <Payment Unique Id> | <Record Type> |
    Examples:
      | Payment Unique Id | Record Type |
      | P0000001006 | Chargeback |