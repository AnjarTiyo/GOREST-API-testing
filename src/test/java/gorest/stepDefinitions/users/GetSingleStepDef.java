package gorest.stepDefinitions.users;

import gorest.env.UsersResponses;
import gorest.env.globalEnv;
import gorest.step.UsersAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetSingleStepDef {

    UsersAPI usersAPI;
    public String URL;
    globalEnv globalEnv;
    @Given("set path to single user {string}")
    public void setPathToSingleUser(String url){
        SerenityRest.given().pathParams("id", globalEnv.usersID);
        URL = url;
    }
    @When("send request get single users from id {string}")
    public void sendRequestGetSingleUsers(String id) {
        SerenityRest.when().get(URL+"?access-token=3c2333def57e12a588eb567a9877a0bf629a6bc7e977432385b8d391445a689e");
    }
//    @And("response body id should be {int}")
//    public void responseBodyIdShouldBeId(int id) {
//        SerenityRest.then().body("data.id", equalTo(id));
//    }
    @And("API send id to dynamic variable")
    public int apiSendIdToDynamicVariable() {
        return globalEnv.usersID = SerenityRest.then().extract().path("data.id");
    }
    @And("get single user json schema")
    public void getSingleUserJsonSchema() {
        File json = new File(System.getProperty("user.dir")+"/src/test/resources/json/schema/getSingleUserSchema.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //GET SINGLE USER INVALID ID [USERS-010]
    @Given("set path to single user {string} invalid id")
    public void setPathToSingleUserInvalidId(String url) {
        URL = url;
    }
    @When("send request get single users from invalid id {string}")
    public void sendRequestGetSingleUsersFromInvalidId(String id) {
        SerenityRest.when().get(URL + "?access-token=3c2333def57e12a588eb567a9877a0bf629a6bc7e977432385b8d391445a689e");
    }
    @Then("should return {int} not found")
    public void shouldReturnNotFound(int notfound) {
        SerenityRest.then().statusCode(notfound);
    }
    @And("response body should contain message {string}")
    public void responseBodyShouldContainMessage(String message) {
        SerenityRest.then()
                .body(UsersResponses.MESSAGE,equalTo(message));
    }
    @And("get single user invalid id json schema")
    public void getSingleUserInvalidIdJsonSchema() {
        File json = new File(UsersAPI.JSON_FILE+"/schema/getSingleUserInvalidSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("set path single to {string}")
    public void setPathSingleTo(String url) {
        URL = url;
    }


}
