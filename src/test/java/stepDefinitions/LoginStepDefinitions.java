package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.SignInPage;
import utils.ConfigReader;
import utils.Driver;

public class LoginStepDefinitions {

    SharedData sharedData;

    public LoginStepDefinitions(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Given("I am on the homepage")
    public void dsbhbfdjsvjhsdbjbfdjsb() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }
    @When("I enter the valid credentials")
    public void i_enter_the_valid_credentials() {
        SignInPage signInPage = new SignInPage();
        signInPage.getUsername().sendKeys(ConfigReader.getProperty("username"));
        signInPage.getPassword().sendKeys(ConfigReader.getProperty("password"));
        signInPage.getLoginButton().click();
    }
    @Then("I should be able to login")
    public void i_should_be_able_to_login() {
        Assert.assertEquals("http://duotify.us-east-2.elasticbeanstalk.com/browse.php?", Driver.getDriver().getCurrentUrl());

    }

    @When("I enter the invalid credentials")
    public void i_enter_the_invalid_credentials() {
        SignInPage signInPage = new SignInPage();
        signInPage.getUsername().sendKeys("username");
        signInPage.getPassword().sendKeys("password");
        signInPage.getLoginButton().click();
    }
    @Then("I should not be able to login")
    public void i_should_not_be_able_to_login() {
        Assert.assertNotEquals("http://duotify.us-east-2.elasticbeanstalk.com/browse.php?", Driver.getDriver().getCurrentUrl());

    }

    @When("I enter invalid username or password")
    public void i_enter_invalid_username_or_password() {
        SignInPage signInPage = new SignInPage();
        signInPage.getUsername().sendKeys("username");
        signInPage.getPassword().sendKeys("password");

    }
    @When("click on the login button")
    public void click_on_the_login_button() {
        new SignInPage().getLoginButton().click();
    }
    @Then("^I should see an error message$")
    public void i_should_see_an_error_message() {
        SignInPage signInPage = new SignInPage();
        Assert.assertTrue(signInPage.getErrorMessage().isDisplayed());
    }



    @When("I enter username as {string} and password as {string}")
    public void i_enter_username_as_and_password_as(String user, String pass) {
                   new SignInPage().login(user,pass);
                   sharedData.setUsername(user);
    }


    @When("I enter same credentials on the ui")
    public void i_enter_same_credentials_on_the_ui() {
        new SignInPage().login(sharedData.getUsername(), sharedData.getPassword());
    }
}
