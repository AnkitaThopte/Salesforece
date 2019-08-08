Feature: Set Supporter Level as High Value and verify the details
  As a Salesforce user, login to Salesforce and set Supporter Level as "High Value" and Verify
  the details

  Scenario Outline: Login to Salesforce URL and Set Supporter level as High Value
    Given I login to Salesforce URL
    When I click on Contacts Page
    And I enter following details in Salutation, First Name, Last Name and Phone fields under New Contact Page:
      | First Name   | Last Name   | Salutation   | Phone   |
      | <First Name> | <Last Name> | <Salutation> | <Phone> |
    And I click on Save button


    Examples:
      | First Name | Last Name | Salutation | Phone      |
      | Oxfam      | Australia | Mr         | 0453613708 |

