package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Homepage;
import pages.SettingsPage;
import pages.UpdateDetailsPage;

public class UpdateEmailStepDefs {

    SharedData sharedData;

    public UpdateEmailStepDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @When("I update the email field to a new random value")
    public void i_update_the_email_field_to_a_new_value() throws InterruptedException {
        sharedData.setRandomEmail(new Faker().internet().emailAddress());
        new Homepage().clickOnUsernameLink();
        new SettingsPage().getUserDetailsButton().click();
        new UpdateDetailsPage().getEmailField().clear();
        new UpdateDetailsPage().getEmailField().sendKeys(sharedData.getRandomEmail());

        new UpdateDetailsPage().getSaveButton().click();
        Thread.sleep(1000);

    }


    @Then("the the success message should be displayed on the UI")
    public void the_the_success_message_should_be_displayed_on_the_ui() throws InterruptedException {
        Assert.assertEquals("Update successful", new UpdateDetailsPage().getSuccessMessage().getText() );

    }
}
