@DB
Feature: Verify basic CRUD operations DB to UI flow

   @create_db
  Scenario: verify user creation in db and validate on the ui  - CREATE
     Given I create a new user in the db with random credentials
     When I enter same credentials on the ui
     Then I should be able to login


   @update_db
  Scenario: Update user email in DB and verify the update on the UI - UPDATE
    Given I update the email for user "duotech2023" in the db
     When I enter username as "duotech2023" and password as "duotech"
     Then I should be able to login
     And The email should be correctly updated


  @delete_db
  Scenario: Create and Delete Playlist - DELETE
    When I enter username as "duotech2023" and password as "duotech"
    Then I should be able to login
    And I create a new playlist with random name
    Then the playlist should be created on the UI
    When the user deletes the same playlist
    Then the playlist should be deleted on the UI
    And the playlist that belongs to the user "duotech2023" should be deleted in the database too




  @create_db_multiple
  Scenario Outline: user creation in db and validate on the ui
    Given I create a new user in the db with the following credentials
      | username   | first   | last   | email   | password   |
      | <username> | <first> | <last> | <email> | <password> |
    When I enter same credentials on the ui
    Then I should be able to login
    And The user is deleted in the database

    Examples:
      | username           | first     | last     | email               | password      |
      | jane.eyre          | Jane      | Eyre     | janeeyre@gmail.com  | janeeyre123   |
      | sherlock.holmes1   | Sherlock  | Holmes   | sherlock@gmail.com  | sherlock      |
      | doctor.watson      | Doctor    | Watson   | drwatson1@gmail.com | drwatson      |
      | professor.moriarty | Professor | Moriarty | moriarty@gmail.com  | moriarty12345 |


