Feature:  Set Supporter Level as Key Supporter and verify the details
  As a Salesforce user, login to Salesforce and set Supporter Level as
  "Key Supporter" and Verify the details

  Scenario Outline:  Login to Salesforce URL and Set Supporter level as Key Supporter
    Given I login to Salesforce URL

    Examples:
      | First Name | Last Name | Salutation |
      | Oxfama     | Australia | Mr         |


  Scenario Outline:  Assign Engagement Plan to Supporters
    Given I login to Salesforce URL
    When I click on Contacts Page
    And I click on Recently Viewed dropdown "Select List View"
    And I select "All Contacts" from the list view
#   And I view list of all contacts under 'All Contacts' page
    And I type the contact "Adut Madut" in the Search box and press Enter to view the particular contact detail
    And I click on the searched contact name.
    And I click on "Related" Tab
    And I click "New" button in the Engagement Plans section
    And I click on Engagement Plan Template textbox and select a plan under New Engagement Plan page
    And I click on Save button
    Then I verify the an Engagement Plan Template and Contact is created
      | Engagement Plan Template   | Contact Name   |
      | <Engagement Plan Template> | <Contact Name> |
    Examples:
      | Engagement Plan Template    | Contact Name |
      | High Value Prospect Journey | Adut Madut   |

