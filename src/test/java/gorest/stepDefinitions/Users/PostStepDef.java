package gorest.stepDefinitions.Users;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import gorest.env.globalEnv;
import gorest.step.Users.UsersAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Managed;

import java.io.File;
import java.util.HashMap;

public class PostStepDef {

    @Managed
    UsersAPI usersAPI;
    globalEnv globalEnv;
    Lorem lorem = LoremIpsum.getInstance();
    public String URL;
    @Given("set path to {string}")
    public void setPathTo(String url) {
//        SerenityRest.given().baseUri(url);
        URL = url;
    }

    @And("set request body post to json data")
    public void setRequestBodyPostToJsonData() {
        HashMap<String, Object> json = new HashMap<String, Object>();
        json.put("name", lorem.getNameMale());
        json.put("email", lorem.getFirstName()+"@email.com");
        json.put("gender", "male");
        json.put("status", "active");
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @When("send request post create new user")
    public void sendRequestPostCreateNewUser() {
        SerenityRest.when().post(URL+"?access-token=3c2333def57e12a588eb567a9877a0bf629a6bc7e977432385b8d391445a689e");
    }
    @Then("should return {int} created")
    public void shouldReturnCreated(int created) {
        SerenityRest.then().statusCode(created);
    }
    @And("post create new user json schema")
    public void postCreateNewUserJsonSchema() {
        File json = new File(UsersAPI.JSON_FILE+"/schema/postCreateSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    @And("API send usersID to dynamic variable")
    public void apiSendUsersIDToDynamicVariable() {
        int response = SerenityRest.then().body("data.id").asString();
        globalEnv.usersID = response;
    }
}
