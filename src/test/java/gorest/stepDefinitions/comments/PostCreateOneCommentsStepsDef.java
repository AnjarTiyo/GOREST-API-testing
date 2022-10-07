package gorest.stepDefinitions.comments;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;


import java.io.File;

public class PostCreateOneCommentsStepsDef {
    public String URL;


    @Given("set path to Post one comment {string}")
    public void setPathToPostOneComments(String url){
        SerenityRest.given().baseUri(url);
        URL=url;
    }

    @And("set request body to JSON data")
    public void setRequestBodyToJSONData() {

    }

    @When("send request POST comments")
    public void sendRequestPOSTComments() {
        SerenityRest.when().post(URL);
    }

    @Then("API should return {int} Created")
    public void apiShouldReturnCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @Then("API should return {int} Unprocessable Entity")
    public void apiShouldReturnUnprocessableEntity(int unprocessable) {
        SerenityRest.then().statusCode(unprocessable);
    }
}
