package gorest.stepDefinitions;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import gorest.env.globalEnv;
import gorest.step.UsersAPI;
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

import static org.hamcrest.CoreMatchers.containsString;

public class PostUsersStepDef {

    @Managed
    UsersAPI usersAPI;
    globalEnv globalEnv;
    Lorem lorem = LoremIpsum.getInstance();
    public String URL;
    @Given("set path post new user to {string}")
    public void setPathTo(String url) {
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
        SerenityRest.when().post(URL+"?access-token=19934441407002a9aecf814831cb9419d81ff581ec62b9b260684801caeef73d");
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
    public int apiSendUsersIDToDynamicVariable() {
//        int response = SerenityRest.then().extract().path("data.id");
//        Serenity.setSessionVariable("usersID").to(SerenityRest.then().extract().path("data.id"));
        return globalEnv.usersID = SerenityRest.then().extract().path("data.id");
    }

    @And("set request body post to invalid json data")
    public void setRequestBodyPostToInvalidJsonData() {
        HashMap<String, Object> json = new HashMap<String, Object>();
        json.put("name", "");
        json.put("email", "");
        json.put("gender", "");
        json.put("status", "");
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @And("response body should contains field {string} and message {string}")
    public void responseBodyShouldContainsFieldAndMessage(String str1, String str2) {
        SerenityRest.then().body(containsString(str2));
    }

    @And("assert usersID not {int}")
    public void assertUsersIDNot(int val) {
        Assert.assertNotEquals(globalEnv.usersID, val);
    }

    @And("assert postsId not {int}")
    public void assertPostsIdNot(int val) {
        Assert.assertNotEquals(globalEnv.postsID, val);
//        String id = Serenity.sessionVariableCalled("postsID");
//        Assert.assertNotEquals(Optional.ofNullable(Serenity.sessionVariableCalled(id)), val);
    }
}

