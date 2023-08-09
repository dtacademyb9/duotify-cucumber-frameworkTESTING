package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.an.E;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ExampleStepDefs {

    SharedData sharedData;


    public ExampleStepDefs(SharedData sharedData){
        this.sharedData = sharedData;
    }


    @Given("I enter random valid username and password")
    public void i_enter_random_valid_username_and_password() {

        Faker faker  = new Faker();

        sharedData.setPassword(faker.internet().password());
       sharedData.setUsername(faker.name().username());

        System.out.println("First step username: " +sharedData.getUsername());
        System.out.println("First step password: " + sharedData.getPassword());

    }



}
