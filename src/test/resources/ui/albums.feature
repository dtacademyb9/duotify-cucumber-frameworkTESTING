Feature: albums

  @albums
  Scenario: Verify album details
    Given the user is on the homepage of the music streaming app
    When the user clicks on the "Your Music" link in the sidebar
    Then the  following albums and their details should be displayed
      | Name    | Author      | Count |
      | Hello   | duotech2023 | 0     |
      | Workout | duotech2023 | 0     |
      | Intense | duotech2023 | 0     |
      | Popular | duotech2023 | 0     |


  Scenario: Default albums
    Given the user is on the homepage of the music streaming app
    When the user clicks on the "Browse" link in the sidebar
    Then the following albums should be displayed
      | Cruel Summer        |
      | Fenix               |
      | Werk                |
      | Marisa              |
      | Escape              |
      | Ultimatum           |
      | Oscillation         |
      | Clouds              |
      | I Am...Sasha Fierce |




  Scenario: Verify album details
    Given the user is on the homepage of the music streaming app
    When the user clicks on the album "Escape"
    Then the album should have the following info
      | name      | Escape           |
      | artist    | Enrique Iglesias |
      | songCount | 5                |



  @temp
  Scenario Outline: Verify multiple album details
    Given the user is on the homepage of the music streaming app
    When the user clicks on the album "<albumName>"
    Then the album should have the following info
      | name      | <albumName>      |
      | artist    | <albumArtist>    |
      | songCount | <albumSongCount> |

    Examples:
      | albumName            | albumArtist      | albumSongCount |
      | Escape               | Enrique Iglesias | 5              |
      | Fenix                | Nicky Jam        | 1              |
      | Ultimatum            | Disclosure       | 1              |
      | Cruel Summer         | Ace Of Base      | 1              |
#      | I Am...Sasha  Fierce | Beyonce          | 1              |
      | Oscillation          | Four Tet         | 1              |
      | Clouds               | Miguel Migs      | 1              |
      | Werk                 | Maya Jane Coles  | 1              |
