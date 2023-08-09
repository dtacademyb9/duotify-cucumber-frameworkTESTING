package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AlbumPage;
import pages.Homepage;
import pages.SignInPage;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

import io.cucumber.datatable.DataTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomepageStepDefs {

    @Given("the user is on the homepage of the music streaming app")
    public void the_user_is_on_the_homepage_of_the_music_streaming_app() {
        SignInPage signInPage = new SignInPage();
        signInPage.getUsername().sendKeys(ConfigReader.getProperty("username"));
        signInPage.getPassword().sendKeys(ConfigReader.getProperty("password"));
        signInPage.getLoginButton().click();
    }
    @Then("the user should see {int} recommended albums displayed on the main page")
    public void the_user_should_see_recommended_albums_displayed_on_the_main_page(Integer countOfAlbums) {

        Integer actual =  new Homepage().getAlbumsNames().size();
        Assert.assertEquals(countOfAlbums, actual);
    }

    @When("the user clicks on the {string} link in the sidebar")
    public void theUserClicksOnTheLinkInTheSidebar(String linkText) {
           new Homepage().clickOnLink(linkText);
           SeleniumUtils.waitFor(1);
    }

    @Then("the user should be able to access their personal music library, where they can view, create, edit and delete playlists.")
    public void theUserShouldBeAbleToAccessTheirPersonalMusicLibraryWhereTheyCanViewCreateEditAndDeletePlaylists() {
        Assert.assertEquals("http://duotify.us-east-2.elasticbeanstalk.com/yourMusic.php?", Driver.getDriver().getCurrentUrl());
    }

    @Then("the user should be able to view and edit their user profile information, such as their name, email address, password and should be able to log out.")
    public void theUserShouldBeAbleToViewAndEditTheirUserProfileInformationSuchAsTheirNameEmailAddressPasswordAndShouldBeAbleToLogOut() {
        Assert.assertEquals("http://duotify.us-east-2.elasticbeanstalk.com/settings.php?", Driver.getDriver().getCurrentUrl());


    }

    @Then("the user should be able to view recommended albums")
    public void theUserShouldBeAbleToViewRecommendedAlbums() {
        Assert.assertEquals("http://duotify.us-east-2.elasticbeanstalk.com/browse.php?", Driver.getDriver().getCurrentUrl());

    }

    @Then("the user should be able to search for an artist, album or tracks")
    public void theUserShouldBeAbleToSearchForAnArtistAlbumOrTracks() {
        Assert.assertEquals("http://duotify.us-east-2.elasticbeanstalk.com/search.php?", Driver.getDriver().getCurrentUrl());


    }


    @When("the user selects the song {string} from the album {string} the user clicks on the play button")
    public void the_user_selects_the_song_from_the_album_the_user_clicks_on_the_play_button(String song, String album) throws InterruptedException {
           Homepage homepage = new Homepage();
           homepage.clickOnAlbum(album);
           new AlbumPage().clickOnPlayButton(song);
            Thread.sleep(1000);

    }
    @Then("the song {string} should start playing")
    public void the_song_should_start_playing(String expectedSongName) {
          Assert.assertEquals(expectedSongName, new AlbumPage().getCurrentSongName().getText());
    }

    @Given("I navigate to the preapproval page")
    public void i_navigate_to_the_preapproval_page() {

    }

    @Then("the links on the page should be the following")
    public void the_links_on_the_page_should_be_the_following(List<String> expectedList) {


        //The data types that cucumber automatically converts for us are of Unmodifiable type
        // IF you need to modify them, you need to create a new modifiable list out of it and modify it

//        System.out.println(actualList.getClass());
//        System.out.println(expectedList.getClass());

        // Sort the datatable list
//        List<String> sorted = new ArrayList<>(expectedList);
//        Collections.sort(sorted);
//        System.out.println(sorted);

        List<String> actualList = SeleniumUtils.getElementsText(new Homepage().getNavBarLinks());
        List<String> latestActual = actualList.subList(0, actualList.size() - 1);

        Assert.assertEquals(expectedList, latestActual);


    }


}
