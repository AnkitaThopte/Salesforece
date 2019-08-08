Feature: To Create new supporter record and verify the details
  As a Salesforce user, login to Salesforce and create new Supporter and Verify
  the details

  Scenario Outline: Add gift to supporter record
    Given I login to Salesforce URL
    When I click on Opportunities dropdown
    And I click New Opportunity button
    And I select Donation button
    And I click the Next button
    And I enter following details in Opportunity Name, Primary Campaign Source, Close Date and Stage fields under New Opportunity: Donation
      | Opportunity Name   | Primary Campaign Source  | Close Date   | Stage   |
      | <Opportunity Name> | <Primary Campaign Source> | <Close Date> | <Stage> |
    And I click on Save button
    Then I verify following details under Opportunity page
      | Opportunity Name   | Primary Campaign Source  | Close Date   | Stage   |
      | <Opportunity Name> | <Primary Campaign Source> | <Close Date> | <Stage> |
    Examples:
      | Opportunity Name   | Primary Campaign Source  | Close Date   | Stage   |
      | flood Relief1 | Flood Relief | 2019-08-27 | Posted |
