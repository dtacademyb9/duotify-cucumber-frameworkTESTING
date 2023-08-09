package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SignInPage;
import pages.SignUpPage;
import utils.DBUtils;
import utils.Driver;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class SignUpStepDefs {


    SharedData sharedData;

    public SignUpStepDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    String username;

    @Given("I click on the sign up link")
    public void i_click_on_the_sign_up_link() {
        SignInPage signInPage = new SignInPage();
        signInPage.getSignUpLink().click();
    }


    @Then("the system should create a new user in the {string} table of the database")
    public void the_system_should_create_a_new_user_in_the_table_of_the_database(String tableName) {

        List<List<Object>> list = DBUtils.getQueryResultAsListOfLists("select username  from "+tableName+" where username='" + username + "1'");
        System.out.println(list);
        Assert.assertTrue(!list.isEmpty());


    }

    @When("I fill up the fields with valid info and click sign up")
    public void i_fill_up_the_fields_with_valid_info_and_click_sign_up() {
        Faker faker = new Faker();
        SignUpPage signUpPage = new SignUpPage();

         sharedData.setUsername(faker.name().username());
        signUpPage.getUsername().sendKeys(sharedData.getUsername());
        signUpPage.getFirstName().sendKeys(faker.name().firstName());
        signUpPage.getLastName().sendKeys(faker.name().lastName());
        String email = faker.internet().emailAddress();
        signUpPage.getEmail().sendKeys(email);
        signUpPage.getEmail2().sendKeys(email);
        String pass = faker.internet().password();
        signUpPage.getPassword().sendKeys(pass);
        signUpPage.getPassword2().sendKeys(pass);
        signUpPage.getRegisterButton().click();
        sharedData.setTimestamp(LocalDateTime.now());  // store the timestamp
    }
    @Then("I should be able to sign up")
    public void i_should_be_able_to_sign_up() {
        Assert.assertEquals("http://duotify.us-east-2.elasticbeanstalk.com/browse.php?", Driver.getDriver().getCurrentUrl());

    }



}
