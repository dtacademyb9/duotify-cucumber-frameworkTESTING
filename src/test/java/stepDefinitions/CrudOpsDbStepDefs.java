package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import pages.Homepage;
import pages.SettingsPage;
import pages.UpdateDetailsPage;
import utils.DBUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class CrudOpsDbStepDefs {


    SharedData sharedData;

    public CrudOpsDbStepDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Given("I create a new user in the db with random credentials")
    public void i_create_a_new_user_in_the_db_with_random_credentials() throws SQLException {

        Faker faker = new Faker();
        sharedData.setUsername(faker.name().username());
        sharedData.setFirst(faker.name().firstName());
        sharedData.setLast(faker.name().lastName());
        sharedData.setRandomEmail(faker.internet().emailAddress());
        String pass = faker.internet().password();
        sharedData.setPassword(pass);
        sharedData.setPassMD5(DigestUtils.md5Hex(pass));

//        String query = "INSERT INTO users (username, firstName, lastName, email, password)\n" +
//                "values('"+username+"', '"+first+"', '"+last+"', '"+email+"', '"+passMD5+"' )";
//

        String query2 = String.format("INSERT INTO users (username, firstName, lastName, email, password)\n" +
                "values('%s', '%s', '%s', '%s', '%s' )", sharedData.getUsername(),
                sharedData.getFirst(),
                sharedData.getLast(),
                sharedData.getRandomEmail(),
                sharedData.getPassMD5() );


        DBUtils.executeUpdate(query2);
    }


    @Given("I update the email for user {string} in the db")
    public void i_update_the_email_for_user_in_the_db(String user) throws SQLException {

         sharedData.setEmail(new Faker().internet().emailAddress());
        String query = String.format("UPDATE users SET email='%s' where username='%s'", sharedData.getEmail(), user);
        DBUtils.executeUpdate(query);
    }
    @Then("The email should be correctly updated")
    public void the_email_should_be_correctly_updated() {
          new Homepage().clickOnUsernameLink();
          new SettingsPage().getUserDetailsButton().click();
        String emailText = new UpdateDetailsPage().getEmailField().getAttribute("value");
        Assert.assertEquals(sharedData.getEmail(), emailText);
    }


    @Given("I create a new user in the db with the following credentials")
    public void i_create_a_new_user_in_the_db_with_the_following_credentials(List<Map<String, String>> dataTable) throws SQLException {

        Map<String, String> map = dataTable.get(0);
        sharedData.setUsername(map.get("username"));
        sharedData.setFirst(map.get("first"));
        sharedData.setLast(map.get("last"));
        sharedData.setEmail(map.get("email"));
        String pass = map.get("password");
        sharedData.setPassword(pass);
        sharedData.setPassMD5(DigestUtils.md5Hex(pass));

//        String query = "INSERT INTO users (username, firstName, lastName, email, password)\n" +
//                "values('"+username+"', '"+first+"', '"+last+"', '"+email+"', '"+passMD5+"' )";
//

        String query2 = String.format("INSERT INTO users (username, firstName, lastName, email, password)\n" +
                        "values('%s', '%s', '%s', '%s', '%s' )", sharedData.getUsername(),
                sharedData.getFirst(),
                sharedData.getLast(),
                sharedData.getEmail(),
                sharedData.getPassMD5() );


        DBUtils.executeUpdate(query2);
    }
    @Then("The user is deleted in the database")
    public void the_user_is_deleted_in_the_database() throws SQLException {
       String query = "DELETE from users where username='"+sharedData.getUsername()+"'";
       DBUtils.executeUpdate(query);
    }

}
