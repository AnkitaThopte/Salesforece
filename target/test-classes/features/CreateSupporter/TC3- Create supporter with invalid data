Feature: To Create new supporter record and verify the details
  As a Salesforce user, login to Salesforce and create new Supporter and Verify
  the details

  Scenario Outline: Create new supporter with invalid data


    Given I login to Salesforce URL
    When I click on Contact dropdown
    And I click on the New Contact under Contact Page

    And I enter following details in Salutation, First Name, Last Name and Phone fields under New Contact Page:
      | First Name   | Last Name   | Salutation   | Phone   |
      | <First Name> | <Last Name> | <Salutation> | <Phone> |

    And I click on Save button
#    5. And I Keep following details empty under  'New Contact' Page.
#    Phone no/email/Mobile.

    Then I verify whether the correct error "Phone number can have only numbers, should not have blank spaces and special character '+' ." message displayed

    Examples:
      | First Name | Last Name | Salutation | Phone |
      | Josh      | Kase | Mr   | agdhhhfey33 |