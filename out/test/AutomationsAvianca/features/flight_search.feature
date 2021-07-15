# Author zair osorio

# language English

  Feature: flight search
    the user is on the page
    fill search form
    I select the second available flight
    @smokeTest
  Scenario: successful search
    Given The user is on the page
    When  Enter the data in the search fields
    And   Search
    Then  show selected flight


