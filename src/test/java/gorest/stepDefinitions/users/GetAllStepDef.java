package gorest.stepDefinitions.users;

import gorest.step.UsersAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;

public class GetAllStepDef {

    public String URL;

    //GET ALL USER WITHOUT PARAMETER PAGE [USERS-004]
    @Given("set path get all to {string}")
    public void setPathGetAllTo(String url){
        String link = "https://gorest.co.in/public/v1/users";
        URL = link;
    }
    @When("send request get all users")
    public void sendRequestGetAllUsers() {
        SerenityRest.when().get(URL);
    }
    @Then("should return {int} ok")
    public void shouldReturnOk(int ok) {
        SerenityRest.then().statusCode(ok);
    }
    @And("response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.then().body("meta.pagination.page", equalTo(page));
    }
    @And("get all user json schema")
    public void getAllUserJsonSchema() {
        File json = new File(UsersAPI.JSON_FILE+"/schema/getAllUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //GET ALL USER WITH PARAMETER PAGE INT [USERS-005]
    @Given("set path to {string} on {string} {string}")
    public void setPathToOnPage(String url, String param, String value) {
        int t = Integer.parseInt(value);
        SerenityRest.given().pathParams(param, t);
        URL = url;
    }
    @And("get all user with parameter page json schema")
    public void getAllUserWithParameterPageJsonSchema() {
        File json = new File(UsersAPI.JSON_FILE+"/schema/getAllUserWithPageSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    ////GET ALL USER WITH PARAMETER PAGE STRING [USERS-006]
    @Given("set path invalid to {string} on {string} {string}")
    public void setPathInvalidToOn(String url, String param, String value) {
        SerenityRest.given().pathParams(param, value);
        URL = url;
    }
    @Then("should return {int} bad request")
    public void shouldReturnBadRequest(int badreq) {
        SerenityRest.then().statusCode(badreq);
    }

    //GET ALL USER WITH PARAMETER GENDER [USERS-008]
    @And("get all user with invalid gender json schema")
    public void getAllUserWithInvalidGenderJsonSchema() {
        File json = new File(UsersAPI.JSON_FILE+"/schema/getAllUserByGenderSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
