@DB
Feature: Verify basic CRUD operations UI to DB flow

   @create
  Scenario: Sign up with valid user details and verify user creation  - CREATE
    Given I click on the sign up link
    When I fill up the fields with valid info and click sign up
    Then I should be able to sign up
    Then the system should create a new user in the "users" table of the database


   @read
  Scenario: Sign up with valid user details and verify user info - READ
    Given I click on the sign up link
    When I fill up the fields with the following info and click sign up
      | username    | first | last   | email                 | password |
      | troy.darwin | Troy  | Darwin | troydarwing@gmail.com | troyd123 |
    Then I should be able to sign up
    Then the created user info in the database should be the following
      | username    | first | last   | email                 | password |
      | troy.darwin | Troy  | Darwin | troydarwing@gmail.com | troyd123 |



   @update
  Scenario: Update user email and verify the update - UPDATE
    When I enter username as "duotech2023" and password as "duotech"
    Then I should be able to login
    When I update the email field to a new random value
    Then the the success message should be displayed on the UI
    And the user email with username "duotech2023" is also updated in the database

  @delete
  Scenario: Create and Delete Playlist - DELETE
    When I enter username as "duotech2023" and password as "duotech"
    Then I should be able to login
    And I create a new playlist with random name
    Then the playlist should be created on the UI
    When the user deletes the same playlist
    Then the playlist should be deleted on the UI
    And the playlist that belongs to the user "duotech2023" should be deleted in the database too