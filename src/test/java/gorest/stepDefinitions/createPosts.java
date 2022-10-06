package gorest.stepDefinitions;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
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
import org.openqa.selenium.remote.Response;

import java.io.File;
import java.util.HashMap;

public class createPosts {
    @Managed
    GorestAPI gorest;
    Lorem lorem = LoremIpsum.getInstance();
    public String URL;
    @Given("set path to {string}+{string}+{string}+{string}")
    public String setPathTo(String param1, String param2, String param3, String param4){
        return gorest.URL = param1+param2+param3+param4;
    }

    @Given("set path to {string} with valid usersID")
    public void setPathToWithValidUsersID(String url) {
//        SerenityRest.given().pathParams("id", 13);
//        SerenityRest.given()
//                .headers("Authorization", "Bearer 10d553d5ddff8744213fde67295563f6ac0a2d296b96f29ad004aa92bdd5ce2b");
        URL = url;
    }

    @And("set request body to valid posts JSON data")
    public void setRequestBodyToJSONData() {
        HashMap<String, Object> json = new HashMap<String, Object>();
        String s1 = lorem.getWords(5,10);
        String s2 = lorem.getParagraphs(1,1);
        json.put("title", "new title");
        json.put("body", "new body");
//        File json = new File(System.getProperty("user.dir")+"/src/test/resources/json/body/postPosts.json");
        SerenityRest.given()
                .headers("Content-Type", "application/json")
                .body(json);
    }

    @When("send request POST create posts")
    public void sendRequestPOSTCreatePosts() {
       SerenityRest.when().post(URL);
    }

    @Then("API should return {int}")
    public void apiShouldReturnOK(int status) {
        SerenityRest.then().statusCode(status);
    }

    @And("assert response body to json schema {string}")
    public void assertResponseBodyToJsonSchema(String file) {
        File json = new File(System.getProperty("user.dir")+"/src/test/resources/json/schema/getAllPosts.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("API send id to dynamic variable")
    public void apiSendIdToDynamicVariable() {
        String response = SerenityRest.then().extract().path("id");
        globalEnv.postsID = response;
    }

    @And("set request body to invalid posts JSON data")
    public void setRequestBodyToInvalidPostsJSONData() {
        HashMap<String, Object> json = new HashMap<String, Object>();
        json.put("title", "");
        json.put("body", "");
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
}
