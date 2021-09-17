@CreateBooking

Feature: Create the Hotel Booking For a specific time period

As a customer I want to create a hotel booking for the holiday


Scenario Outline: Create a new Hotel Booking
    Given I am on the Hotel Booking home page
    When I enter my Firstname as <firstname>
    And I enter my Lastname as <lastname>
    And I enter the price as <price>
    And I enter the <deposit> paid
    And I enter the Checkin date as <checkin>
    And I enter the Checkout date as <checkout>
    And I click on the save button
    Then The booking is saved successfully for <firstname>

Examples:
    |firstname |lastname|price  |deposit|checkin       |checkout       |
    |Test1      |User1    |100    |true   |2019-05-15    |2019-05-20     |
    |sb        |B       |-100   |false  |2019-05-15    |2019-05-20     |
    |354445    |345345  |15000  |true   |2019-06-19    |2019-06-28     |
    |£%%$$%    |$%^$%^$ |2000   |true   |2019-06-19    |2019-06-28     |
    |Test2    |User2    |100.25|true   |2019-06-19    |2019-06-28     |
    |Test3     |User3    |-100.25|true |2019-06-19     |2019-06-28     |
    |The quick brown fox jumped over the lazy dog The quick brown fox jumped over the lazy dog The quick brown fox jumped over the lazy dog The quick brown fox jumped over the lazy dog The quick brown fox jumped over the lazy dog The quick brown fox jumped over the lazy dog The quick brown fox jumped over the lazy dog The quick brown fox jumped over the lazy dog |The quick brown fox jumped over the lazy dog The quick brown fox jumped over the lazy dog The quick brown fox jumped over the lazy dog The quick brown fox jumped over the lazy dog The quick brown fox jumped over the lazy dog The quick brown fox jumped over the lazy dog The quick brown fox jumped over the lazy dog The quick brown fox jumped over the lazy dog |100|true|2019-06-19|2019-06-28|


