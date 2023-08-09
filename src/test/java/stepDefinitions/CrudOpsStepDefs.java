package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import pages.*;
import utils.DBUtils;
import utils.SeleniumUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CrudOpsStepDefs {


    SharedData sharedData;

    public CrudOpsStepDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @When("I fill up the fields with the following info and click sign up")
    public void i_fill_up_the_fields_with_the_following_info_and_click_sign_up(List<Map<String, String>> dataTable) {

        SignUpPage signUpPage = new SignUpPage();

        System.out.println(dataTable);
        Map<String, String> row = dataTable.get(0);
        System.out.println(row);

        signUpPage.getUsername().sendKeys(row.get("username"));
        signUpPage.getFirstName().sendKeys(row.get("first"));
        signUpPage.getLastName().sendKeys(row.get("last"));
//
        signUpPage.getEmail().sendKeys(row.get("email"));
        signUpPage.getEmail2().sendKeys(row.get("email"));

        signUpPage.getPassword().sendKeys(row.get("password"));
        signUpPage.getPassword2().sendKeys(row.get("password"));
        signUpPage.getRegisterButton().click();


    }



    String expectedUsername;
    @Then("the created user info in the database should be the following")
    public void the_created_user_info_in_the_database_should_be_the_following(List<Map<String, String>> expected) throws SQLException {

        Map<String, String> expectedData = expected.get(0);
        expectedUsername = expectedData.get("username");
        String expectedFirst = expectedData.get("first");
        String expectedLast = expectedData.get("last");
        String expectedEmail = expectedData.get("email");
        String expectedPass = expectedData.get("password");  // troy123

        String expectedPassMd5 = DigestUtils.md5Hex(expectedPass);




//        System.out.println("Expected: " + expectedData);

        List<Map<String, Object>> listOfMaps = DBUtils.getQueryResultListOfMaps("select username, firstName, lastName, email, password  from users where username='" + expectedUsername + "'");

        Map<String, Object> actualDBData = listOfMaps.get(0);

//        System.out.println("Actual: " + actualDBData);

        try {
            Assert.assertEquals(expectedUsername, actualDBData.get("username"));
            Assert.assertEquals(expectedFirst, actualDBData.get("firstName"));
            Assert.assertEquals(expectedLast, actualDBData.get("lastName"));
//            Assert.assertEquals(expectedEmail, actualDBData.get("email"));
            Assert.assertEquals(expectedPassMd5, actualDBData.get("password"));
        }finally {
            DBUtils.executeUpdate("DELETE FROM users WHERE username='"+expectedUsername+"'");
        }

    }









    @Then("I create a new playlist with random name")
    public void i_create_a_new_playlist_with_the_following_details() throws InterruptedException {
         new Homepage().clickOnLink("Your Music");
         new AllPlaylistsPage().getNewPlaylistButton().click();
       sharedData.setRandomPlaylistName(new Faker().funnyName().name());
         new AllPlaylistsPage().enterPlaylistName(sharedData.getRandomPlaylistName());



    }
    @Then("the playlist should be created on the UI")
    public void the_playlist_should_be_created_on_the_ui() {
           Assert.assertTrue(new AllPlaylistsPage().getPlaylistByName(sharedData.getRandomPlaylistName()).isDisplayed());
    }
    @When("the user deletes the same playlist")
    public void the_user_deletes_the_playlist_with_the_following_details() throws InterruptedException {
           new AllPlaylistsPage().clickPlaylistByName(sharedData.getRandomPlaylistName());
           new PlaylistPage().getDeleteButton().click();
           new PlaylistPage().acceptDeleteAlert();

    }
    @Then("the playlist should be deleted on the UI")
    public void the_playlist_should_be_deleted_on_the_ui() {

        List<String> allPlaylists = SeleniumUtils.getElementsText(new AllPlaylistsPage().getAllPlaylists());
        // Check if the playlist that we just deleted is part of the current playlist
        System.out.println(allPlaylists);
        Assert.assertTrue(!allPlaylists.contains(sharedData.getRandomPlaylistName()));


    }
    @Then("the playlist that belongs to the user {string} should be deleted in the database too")
    public void the_playlist_that_belongs_to_the_user_should_be_deleted_in_the_database_too(String user) {
        String sqlStatement = "select name from playlists where owner='"+user+"'";

        List<List<Object>> listOfLists = DBUtils.getQueryResultAsListOfLists(sqlStatement);

        List<String> firstColumnDataAsList = DBUtils.getColumnData(listOfLists, 0);

        System.out.println(firstColumnDataAsList);

        Assert.assertTrue(!firstColumnDataAsList.contains(sharedData.getRandomPlaylistName()));


    }


    @Then("the user email with username {string} is also updated in the database")
    public void the_user_email_with_username_is_also_updated_in_the_database(String username) {

        List<List<Object>> listOfList = DBUtils.getQueryResultAsListOfLists("SELECT email from users where username='" + username + "'");
        String actualEmail = (String)listOfList.get(0).get(0);

        Assert.assertEquals(sharedData.getRandomEmail(),actualEmail);



    }






}
