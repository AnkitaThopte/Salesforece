# new feature
# Tags: optional
    
Feature: Verify Create a new Lead
  As a Salesforce user, login to Salesforce and Create a new Lead

  Scenario Outline: Verify Create a new Contact with record type as Director
 # Scenario:  Verify Create a new Lead
    Given I login to Salesforce URL
    When I click on Contacts tag
    And I click New button on right hand side of the page
  #  And I select Director as a record type
    And I click the Next button
    And I fill Basic Details as First Name, Last Name, Pan No, Customer Group Name, Lead Source and DIN
      |First Name| Last Name |Pan No | Customer Group Name | Lead Source | DIN |
      |<First Name>| <Last Name> | <Pan No> | <Customer Group Name> | <Lead Source> | <DIN> |
    And I fill Detail information Title, Relationship with promoters/founders, Reports To, %Holding, Experience in line of this activity and Networth as per IT Returns
     |Title | Relationship with promoters/founders | Reports To | %Holding | Experience in line of this activity | Networth as per IT Returns |
      | <Title> | <Relationship with promoters/founders> | <Reports To> |<%Holding> | <Experience in line of this activity> | <Networth as per IT Returns> |
    And I click on Save button
    And I again click Contacts tab
    And I type the leads "Maxwell Waynen" in the Search box and press Enter to view the particular contact detail
    And I click on the searched lead name
    And I click on "Details" Tab
    Then I verified Lead is successfully created First Name, Last Name, Pan No, Customer Group Name, Lead Source, DIN, Title, Relationship with promoters/founders, Reports To, %Holding, Experience in line of this activity and Networth as per IT Returns
    Examples:
      |First Name| Last Name |Pan No | Customer Group Name | Lead Source | DIN | Title | Relationship with promoters/founders | Reports To | %Holding | Experience in line of this activity | Networth as per IT Returns |
      |  Maxwell    | Waynen     | ASXD74851T | Group AAC | Web | 78458852 | Director | Beneficial Owner | Amit Deshpande | 70% | 8 | 30 |