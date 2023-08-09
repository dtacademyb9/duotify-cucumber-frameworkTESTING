@DB
Feature: Verify business rules

    @db_only
  Scenario: verify column names for songs table
     When I retrieve the column names from the "songs" table
     Then it should have the following
       | id         |
       | title      |
       | artist     |
       | album      |
       | genre      |
       | duration   |
       | path       |
       | albumOrder |
       | plays      |

  @genres @db_only
  Scenario: Verify genres
    When I send a query to retrieve genres from the db
    Then The result should contain the following genres
      | rap       |
      | pop       |
      | techno    |
      | rnb       |
      | house     |
      | classical |
      | jazz      |
      | electronic |
      | dance     |
      | reggae    |
      | reggaeton |


  @business_rule @db_only
  Scenario: verify email column for duplicates
    When I retrieve the emails from "users" table
    Then it should not contain duplicates
    Then it should not contain duplicates using sql query


   @playCount
  Scenario: Successful Song Playback
    Given I enter the valid credentials
    Then I should be able to login
    And I play a song "Whirls" from the album "Werk"
    Then the play count of the song in the database should be incremented by one


   @playlistSongs
  Scenario: Successfully adding a song to a playlist
    Given I enter username as "duotech2023" and password as "duotech"
    Then I should be able to login
    And I add a song "Salty Dub"  from album "Clouds" to the playlist "House"
    Then I should have the same song added to playlistSongs table
    And the song should be deleted from the playlist


   @timestamp
  Scenario: Validate the timestamp
    Given I click on the sign up link
    When I fill up the fields with valid info and click sign up
    Then I should be able to sign up
    And the timestamp should be correct