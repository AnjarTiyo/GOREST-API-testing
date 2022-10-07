package gorest.stepDefinitions.users;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import gorest.env.UsersResponses;
import gorest.env.globalEnv;
import gorest.step.GorestAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Managed;
import org.junit.Assert;

import java.io.File;
import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;

public class PostStepDef {

    @Managed
    GorestAPI gorest;
    globalEnv globalEnv;
    Lorem lorem = LoremIpsum.getInstance();
    public String URL;

    //POST CREATE NEW USER VALID JSON [USERS-001]
    @Given("set path post new user to {string}")
    public void setPathTo(String url) {
        String link = "https://gorest.co.in/public/v1/users";
        URL = link;
    }
    @And("set request body post to json data")
    public void setRequestBodyPostToJsonData() {
        HashMap<String, Object> json = new HashMap<String, Object>();
        String s1 = lorem.getNameMale();
        String s2 = lorem.getFirstName()+"@email.com";
        String s3 = "male";
        String s4 = "active";
        json.put("name", s1);
        json.put("email", s2);
        json.put("gender", s3);
        json.put("status", s4);
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @When("send request post create new user")
    public void sendRequestPostCreateNewUser() {
        SerenityRest.when().post(URL+"?access-token=3c2333def57e12a588eb567a9877a0bf629a6bc7e977432385b8d391445a689e");
    }
    @Then("API should return {int} created")
    public void apiShouldReturnCreated(int created) {
        SerenityRest.then().statusCode(created);
    }
    @And("post create new user json schema")
    public void postCreateNewUserJsonSchema() {
        File json = new File(System.getProperty("user.dir")+"/src/test/resources/json/schema/postCreateSchema.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @And("API send usersID to dynamic variable")
    public int apiSendUsersIDToDynamicVariable() {
        return globalEnv.usersID = SerenityRest.then().extract().path("data.id");
    }
    @And("assert usersID not {int}")
    public void assertUsersIDNot(int val) {
        Assert.assertNotEquals(globalEnv.usersID, val);
    }

    //POST CREATE NEW USER INVALID JSON [USERS-002]
    @And("set request body post to invalid json data")
    public void setRequestBodyPostToInvalidJsonData() {
        HashMap<String, Object> json = new HashMap<String, Object>();
        String s1 = lorem.getNameMale();
        String s3 = "male";
        String s4 = "active";
        json.put("name", s1);
        json.put("gender", s3);
        json.put("status", s4);
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Then("API should return {int} Unprocessable Entity")
    public void apiShouldReturnUnprocessableEntity(int unprocess) {
        SerenityRest.then().statusCode(unprocess);
    }

    @And("response body should contains message {string}")
    public void responseBodyShouldContainsFieldAndMessage(String message) {
        SerenityRest.then()
                .body(UsersResponses.MESSAGE,equalTo(message));
    }

    @And("post create new user invalid json schema")
    public void postCreateNewUserInvalidJsonSchema() {
        File json = new File(System.getProperty("user.dir")+"/src/test/resources/json/schema/postCreateInvalidSchema.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}