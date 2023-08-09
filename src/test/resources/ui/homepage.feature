@REGRESSION
Feature: Music Streaming App Homepage

  As a music lover, I want to be able to access and explore music easily through a music streaming app.
  The homepage of the app should display 9 albums on the main page and
  have a left sidebar with links to Search, Browse, Your Music, and Edit User profile options.


  Scenario: User opens the app and sees certain number of recommended albums on the homepage
    Given the user is on the homepage of the music streaming app
    Then the user should see 5 recommended albums displayed on the main page
#
#  Scenario: User clicks on an album and is taken to the album page
#    Given the user is on the homepage of the music streaming app
#    When the user clicks on an album
#    Then the user should be taken to the album page, where they can view its tracklist, see album information such as Title, Artist and Song Count.
#
  @test
  Scenario: User clicks on the Your Music link in the sidebar
    Given the user is on the homepage of the music streaming app
    When the user clicks on the "Your Music" link in the sidebar
    Then the user should be able to access their personal music library, where they can view, create, edit and delete playlists.

  @test
  Scenario: User clicks on the Username link in the sidebar
    Given the user is on the homepage of the music streaming app
    When the user clicks on the "Duotech Academy" link in the sidebar
    Then the user should be able to view and edit their user profile information, such as their name, email address, password and should be able to log out.
  @test
  Scenario: User clicks on the Browse link in the sidebar
    Given the user is on the homepage of the music streaming app
    When the user clicks on the "Browse" link in the sidebar
    Then the user should be able to view recommended albums

   @test
  Scenario: User clicks on the Search link in the sidebar
    Given the user is on the homepage of the music streaming app
    When the user clicks on the "Search" link in the sidebar
    Then the user should be able to search for an artist, album or tracks
##
  @song
  Scenario: User plays a song from an album
    Given the user is on the homepage of the music streaming app
    When the user selects the song "Maybe" from the album "Escape" the user clicks on the play button
    Then the song "Maybe" should start playing


#  Scenario: User plays a song from an album
#    Given I navigate to the preapproval page
#    When I click on Products link
#    Then I should see a price 23.55

  @songDD
  Scenario Outline: User plays a song from an album
    Given the user is on the homepage of the music streaming app
    When the user selects the song "<song>" from the album "<album>" the user clicks on the play button
    Then the song "<song>" should start playing

    Examples:
      | song               | album        |
      | Marisa             | Marisa       |
      | Daughter           | Oscillation  |
      | Hero               | Escape       |
      | Maybe              | Escape       |
      | Salty Dub          | Clouds       |
      | All That She Wants | Cruel Summer |

     @datatable
    Scenario: Verify Homepage links
      Given the user is on the homepage of the music streaming app
      Then the links on the page should be the following
        | Search     |
        | Browse     |
        | Your Music |
      And the user should be able to view and edit their user profile information, such as their name, email address, password and should be able to log out.
#      single column -> list