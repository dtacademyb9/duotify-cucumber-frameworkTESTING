package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import pages.AlbumPage;
import pages.Homepage;
import pages.PlaylistPage;
import utils.SeleniumUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class AlbumStepDefs {


    @Then("the  following albums and their details should be displayed")
    public void the_following_albums_and_their_details_should_be_displayed(List<Map<String, String>> expected) throws InterruptedException {

        PlaylistPage playlistPage = new PlaylistPage();
        for (Map<String, String> playlist : expected) {

            playlistPage.clickOnPlaylist(playlist.get("Name"));
            Assert.assertEquals(playlist.get("Author"), playlistPage.getUsername().getText().split(" ")[1]);
            Assert.assertEquals(playlist.get("Count"), playlistPage.getSongCount().getText().split(" ")[0]);
            Thread.sleep(500);
            new Homepage().clickOnLink("Your Music");

        }

    }


    @Then("the following albums should be displayed")
    public void the_following_albums_should_be_displayed(List<String> expected) {

        List<String> actual = SeleniumUtils.getElementsText(new Homepage().getAlbumsNames());

        List<String> expectedMod =  new ArrayList<>(expected);
        Collections.sort(expectedMod);
        Collections.sort(actual);

        Assert.assertEquals(expectedMod,actual);
    }


    @When("the user clicks on the album {string}")
    public void the_user_clicks_on_the_album(String album) {
        new Homepage().clickOnAlbum(album);
    }
    @Then("the album should have the following info")
    public void the_album_should_have_the_following_info(Map<String, String> expected) {

        String expectedName = expected.get("name");
        String expectedartist = expected.get("artist");
        String expectedsongCount = expected.get("songCount");

        AlbumPage albumPage = new AlbumPage();

      // Hard assertions from JUnit 4
        Assert.assertEquals(expectedName, albumPage.getAlbumName());
        Assert.assertEquals(expectedartist, albumPage.getArtistName());
        Assert.assertEquals(expectedsongCount, albumPage.getSongCount());


        // Soft assertions from AssertJ
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(albumPage.getAlbumName()).isEqualTo(expectedName);
        softAssertions.assertThat(albumPage.getArtistName()).isEqualTo(expectedartist);
        softAssertions.assertThat(albumPage.getSongCount()).isEqualTo(expectedsongCount);

        softAssertions.assertAll();


    }

}
