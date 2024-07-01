Feature: Search for a Product on an E-commerce Mobile Application
  @AddToCart
  Scenario: Successful product search for "iPhone15"
    Given User launches amazon application
    And User clicks on Skip_Sign_in
    When User enter "iPhone15" in the search bar
    And User clicks on search button
    Then User should see a list of search results related to "iPhone15"
    And User taps on the first search result
  #  Then User should be navigated to the product details page for that item
  #  And User clicks on Add to cart
  #  And User clicks on View shopping cart