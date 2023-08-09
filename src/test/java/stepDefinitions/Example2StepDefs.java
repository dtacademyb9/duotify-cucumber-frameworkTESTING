package stepDefinitions;

import io.cucumber.java.en.Then;

public class Example2StepDefs {


    SharedData sharedData;

    public Example2StepDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Then("I should have the same username and password in the database")
    public void i_should_have_the_same_username_and_password_in_the_database() {

        System.out.println("Second step username: " + sharedData.getUsername());
        System.out.println("Second step password: " + sharedData.getPassword());

    }



}
