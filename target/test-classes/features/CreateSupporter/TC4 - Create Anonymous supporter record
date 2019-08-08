Feature: To Create new supporter record and verify the details
  As a Salesforce user, login to Salesforce and create new Supporter and Verify
  the details

  Scenario Outline: Create new supporter with invalid data


    Given I login to Salesforce URL
    When I click on Contact dropdown
    And I click on the New Contact under Contact PageNew Contact under Contact Page

    And I enter following details in Salutation, First Name, Last Name and Phone fields under New Contact Page:
      | First Name   | Last Name   | Salutation   | Phone   |
      | <First Name> | <Last Name> | <Salutation> | <Phone> |
    And I click on "Is Anonymous" check box
    And I click on Save button
    And I click on "Details" Tab
    And I scroll down to page
    Then I verify Anonymous supporter record created
      |  Name   | Phone   |
      | <Name> | <Phone> |
    Examples:
      | First Name | Last Name | Salutation | Phone |
      | Jonh      | Kaste | Captain   | 98764429533 |