Feature: Medicare_Amazon
  @MedicareAmazon
  Scenario: Medicare_Amazon
    Given User launches amazon application
    And User clicks on Skip_Sign_in
    And User selects location
    And User enters zipcode
    And User clicks on Apply
    And User clicks on MedicalCare
    Then User verify presence of Sign_in_Page