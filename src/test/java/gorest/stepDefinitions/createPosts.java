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

import java.io.File;
import java.util.HashMap;

public class createPosts {
    @Managed
    GorestAPI gorest;
    Lorem lorem = LoremIpsum.getInstance();
    public String URL;

    @Given("set path to {string}+{string}+{string}+{string}")
    public String setPathTo(String param1, String param2, String param3, String param4) {
        return gorest.URL = param1 + param2 + param3 + param4;
    }

    @Given("set path to {string} with valid usersID")
    public String setPathToWithValidUsersID(String url) {
        return URL = "https://gorest.co.in/public/v1/users/" + globalEnv.usersID + "/posts/";
    }

    @And("set request body to valid posts JSON data")
    public void setRequestBodyToJSONData() {
        HashMap<String, Object> json = new HashMap<String, Object>();
        String s1 = lorem.getWords(2, 4);
        String s2 = lorem.getWords(10, 20);
        json.put("title", s1);
        json.put("body", s2);
//        File json = new File(System.getProperty("user.dir")+"/src/test/resources/json/body/postPosts.json");
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @When("send request POST create posts")
    public void sendRequestPOSTCreatePosts() {
        SerenityRest.when().post(URL + "?access-token=32441f3f8fe63c08acb2d18fd19d853ba2c24cc037cb7c72ad65ce40a382010c");
    }

    @Then("API should return {int}")
    public void apiShouldReturnOK(int status) {
        SerenityRest.then().statusCode(status);
    }

    @And("assert response body to json schema {string}")
    public void assertResponseBodyToJsonSchema(String file) {
        File json = new File(System.getProperty("user.dir") + "/src/test/resources/json/schema/getAllPosts.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("API send postsID to dynamic variable")
    public int apiSendIdToDynamicVariable() {
        return globalEnv.postsID = SerenityRest.then().extract().path("data.id");
    }

    @And("set request body to invalid posts JSON data")
    public void setRequestBodyToInvalidPostsJSONData() {
        HashMap<String, Object> json = new HashMap<String, Object>();
        json.put("title", "");
        json.put("body", "");
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @When("send request POST create posts invalid users")
    public void sendRequestPOSTCreatePostsInvalidUsers() {
        SerenityRest.when().post(URL + "?access-token=3c2333def57e12a588eb567a9877a0bf629a6bc7e977432385b8d391445a689e");
    }

    @Given("set path to {string} with invalid usersID")
    public void setPathToWithInvalidUsersID(String url) {
        URL = url;
    }

    @Given("set path to {string} for single post")
    public void setPathToForSinglePost(String url) {
//        String str = Serenity.sessionVariableCalled("postsID");
        SerenityRest.given().pathParams("id", globalEnv.postsID);
        URL = url;
    }

    @When("send request GET single posts from id {string}")
    public void sendRequestGETSinglePostsFromId(String id) {
        SerenityRest.when().get(URL + "?access-token=3c2333def57e12a588eb567a9877a0bf629a6bc7e977432385b8d391445a689e");
    }

    @Given("set path to {string} for users post")
    public void setPathToForUsersPost(String url) {
        SerenityRest.given().pathParams("id", globalEnv.usersID);
        URL = url;
    }

    @When("send request GET single posts from invalid id {string}")
    public void sendRequestGETSinglePostsFromInvalidId(String id) {
        SerenityRest.when().get(URL + "?access-token=3c2333def57e12a588eb567a9877a0bf629a6bc7e977432385b8d391445a689e");
    }

    @Given("set path to {string} for invalid id")
    public void setPathToForInvalidPostID(String url) {
        URL = url;
    }

    @Given("set path to {string} for users never post")
    public void setPathToForUsersNeverPost(String url) {
        URL = url;
    }

    @Given("set path to {string} for put update post")
    public void setPathToForPutUpdatePost(String url) {
        URL = url;
    }

    @And("set request body to valid posts update JSON data")
    public void setRequestBodyToValidPostsUpdateJSONData() {
        HashMap<String, Object> json = new HashMap<String, Object>();
        String s1 = "new title";
        String s2 = lorem.getWords(10, 20);
        json.put("title", s1);
        json.put("body", s2);
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .pathParams("id", globalEnv.postsID);
    }

    @When("send request PUT update posts")
    public void sendRequestPUTUpdatePosts() {
        SerenityRest.when().put(URL + "?access-token=10d553d5ddff8744213fde67295563f6ac0a2d296b96f29ad004aa92bdd5ce2b");
    }

    @When("send request PUT update posts from invalid id")
    public void sendRequestPUTUpdatePostsFromInvalidId() {
        HashMap<String, Object> json = new HashMap<String, Object>();
        String s1 = "new title";
        String s2 = lorem.getWords(10, 20);
        json.put("title", s1);
        json.put("body", s2);
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .when().put(URL + "?access-token=10d553d5ddff8744213fde67295563f6ac0a2d296b96f29ad004aa92bdd5ce2b");
    }

    @When("send request PUT update posts invalid body")
    public void sendRequestPUTUpdatePostsInvalidBody() {
        HashMap<String, Object> json = new HashMap<String, Object>();
        json.put("title", "");
        json.put("body", "");
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .given().pathParams("id", globalEnv.postsID)
                .when().put(URL + "?access-token=10d553d5ddff8744213fde67295563f6ac0a2d296b96f29ad004aa92bdd5ce2b");
    }

    @When("send request PUT update posts without body")
    public void sendRequestPUTUpdatePostsWithoutBody() {
        SerenityRest.given().pathParams("id", globalEnv.postsID)
                .when().put(URL + "?access-token=10d553d5ddff8744213fde67295563f6ac0a2d296b96f29ad004aa92bdd5ce2b");
    }

    @When("send request PATCH update posts")
    public void sendRequestPATCHUpdatePosts() {
        SerenityRest.when().put(URL + "?access-token=10d553d5ddff8744213fde67295563f6ac0a2d296b96f29ad004aa92bdd5ce2b");
    }

    @And("set request body to valid patch update JSON data")
    public void setRequestBodyToValidPatchUpdateJSONData() {
        HashMap<String, Object> json = new HashMap<String, Object>();
        json.put("title", "title patch");
        json.put("new_feature", "");
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .pathParams("id", globalEnv.postsID);
    }

    @When("send request DEL single posts from id {string}")
    public void sendRequestDELSinglePostsFromId(String id) {
        SerenityRest.when().delete(URL + "?access-token=7ac1b26f8a04f41c988a284ffa38a91b0007d46c9f3374755d15bfeb5fd70e81");
    }

    @When("send request DEL single posts from invalid {string}")
    public void sendRequestDELSinglePostsFromInvalid(String id) {
        SerenityRest.when().delete(URL + "?access-token=7ac1b26f8a04f41c988a284ffa38a91b0007d46c9f3374755d15bfeb5fd70e81");
    }

    @Given("set path to {string} for delete invalid postID")
    public void setPathToForDeleteInvalidPostID(String url) {
        URL = url;
    }
}
