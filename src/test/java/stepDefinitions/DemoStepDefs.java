package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Do;
import io.cucumber.java.it.Ma;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utils.Driver;

import java.util.List;
import java.util.Map;

public class DemoStepDefs {

    @Given("I have {int} {string}")
    public void i_have(Integer count, String veggie) {
        System.out.println("I have " + count + " " + veggie);
    }
    @When("I take {double} away")
    public void i_take_away(Double double1) {
        System.out.println("I took away " + double1);
    }
    @Then("I should have {double} left")
    public void i_should_have_left(Double double1) {
        System.out.println("I have left " + double1);
    }

    @Then("I/He still/yet feel(s) {word}")
    public void i_still_feel_hungry(String word) {
        System.out.println("I feel " + word);
    }


    @Given("I have the the query")
    public void i_have_the_the_query(String docString) {
        System.out.println(docString);
    }
    @When("send the query")
    public void send_the_query() {

    }
    @Then("should have the result")
    public void should_have_the_result() {

    }

    @Given("I am on the google search page")
    public void i_am_on_the_google_search_page() {
        Driver.getDriver().get("https://www.google.com/");
    }
    @When("I search for a {string}")
    public void i_search_for_a(String searchTerm) {
        Driver.getDriver().findElement(By.name("q")).sendKeys(searchTerm, Keys.ENTER);
    }
    @Then("The title of the results page should contain {string}")
    public void the_title_of_the_results_page_should_contain(String string) {
         Assert.assertTrue(Driver.getDriver().getTitle().contains(string));
    }



    @When("I click on {string} link")
    public void iClickOnLink(String args) {
    }

//    @When("I click on {word} link")
//    public void iClickOnUserInfoLink() {
//
//    }

    @Then("I should see a price {double}")
    public void i_should_see_a_price(Double price) {

    }

//    @Then("I should see a price {float}")
//    public void i_should_see_a_pricedcs(Float price) {
//
//    }


    @Given("I have the following table")
    public void i_have_the_following_table(List<List<String>> dataTable) {
        System.out.println(dataTable);
        System.out.println(dataTable.get(0).get(1));
    }


    @Given("I have the following table as")
    public void i_have_the_following_table_as(List<Map<String, String>> dataTable) {
        System.out.println(dataTable);
        System.out.println(dataTable.get(1).get("birthDate"));
    }

    @Given("I have the following table as map")
    public void i_have_the_following_table_as_map(Map<String, String> dataTable) {
        System.out.println(dataTable);
    }

    @Given("I have the following table as map where the value is a list")
    public void i_have_the_following_table_as_map_where_the_value_is_a_list(Map<String, List<Double>> dataTable) {
        System.out.println(dataTable);
        System.out.println(dataTable.get("KSFO").get(1));
    }



}
