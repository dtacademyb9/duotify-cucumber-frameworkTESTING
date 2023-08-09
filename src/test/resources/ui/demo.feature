Feature: Demo

  @demo
  Scenario: Demo
    Given I have 12 "cakes"
    When I take 6.5 away
    Then I should have 5.5 left
    And I still feel happy


  @demo
  Scenario: Demo
    Given I have 34 "cukes"
    When I take 34 away
    Then I should have 0 left
    And He yet feels hungry

  @docString
  Scenario: Demo of string
    Given I have the the query
         """
          UPDATE User
          SET UserId = 12345
          , Name = 'J Doe'
          , Location = 'USA'
          , Bio='my bio
          spans
          multiple
          lines!'
          WHERE UserId = 12345
       """
    When send the query
    Then should have the result

  @duplicate
  Scenario: Demo of duplicate step defintion
    Given I navigate to the preapproval page
    When I click on "Browse" link
    Then I should see a price 23.55


   @scenarioOutline
   Scenario Outline: Test google search
     Given I am on the google search page
     When I search for a "<searchTerm>"
     Then The title of the results page should contain "<searchTerm>"

    Examples:
      | searchTerm |
      | Chicken    |
      | Bottle     |
      | Iphone     |
      | Flower     |

      @dt
     Scenario: Demo of datatable as List of Lists

       Given I have the following table
         | Annie M. G. | Schmidt  | 1911-03-20 |
         | Roald       | Dahl     | 1916-09-13 |
         | Astrid      | Lindgren | 1907-11-14 |
#         list of lists

  @dt
  Scenario: Demo of datatable as List of Maps

    Given I have the following table as
         | firstName   | lastName | birthDate  |
         | Annie M. G. | Schmidt  | 1911-03-20 |
         | Roald       | Dahl     | 1916-09-13 |
         | Astrid      | Lindgren | 1907-11-14 |
#     list of maps when there is a header row



  @dt
  Scenario: Demo of datatable as map
    Given I have the following table as map
         | KMSY | Louis Armstrong New Orleans International Airport     |
         | KSFO | San Francisco International Airport               	|
         | KSEA | Seattle-Tacoma International Airport              	|
         | KJFK | John F. Kennedy International Airport             	|
#     key value pair style table -> map

  @dt
  Scenario: Demo of datatable as map where the value is a list
    Given I have the following table as map where the value is a list

         | KMSY | 29.993333 |  -90.258056 |
         | KSFO | 37.618889 | -122.375000 |
         | KSEA | 47.448889 | -122.309444 |
         | KJFK | 40.639722 |  -73.778889 |
#


  @shareData
  Scenario: Demo
    Given I enter random valid username and password
    Then I should have the same username and password in the database

