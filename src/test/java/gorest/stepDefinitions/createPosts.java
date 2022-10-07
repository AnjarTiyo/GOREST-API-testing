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
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Managed;
import okhttp3.ResponseBody;

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
//        String str = Integer.toString(globalEnv.usersID);
        String link = "https://gorest.co.in/public/v1/users/"+globalEnv.usersID+"/posts/";
//        SerenityRest.given().pathParams("usersID", globalEnv.usersID);
        URL = link;
    }

    @And("set request body to valid posts JSON data")
    public void setRequestBodyToJSONData() {
        HashMap<String, Object> json = new HashMap<String, Object>();
        String s1 = lorem.getWords(2,4);
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
        SerenityRest.when().post(URL+"?access-token=3c2333def57e12a588eb567a9877a0bf629a6bc7e977432385b8d391445a689e");
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

    @And("API send postsID to dynamic variable")
    public int apiSendIdToDynamicVariable() {
//        globalEnv.postsID = SerenityRest.then().extract().path("data.id");
//        Response response = Serenity.sessionVariableCalled("response");
//        Serenity.setSessionVariable("postsID").to(SerenityRest.then().extract().path("data.id"));
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
        SerenityRest.when().post(URL+"?access-token=3c2333def57e12a588eb567a9877a0bf629a6bc7e977432385b8d391445a689e");
    }

    @Given("set path to {string} with invalid usersID")
    public void setPathToWithInvalidUsersID(String url) {
        URL = url;
    }

    @Given("set path to {string} for single post")
    public void setPathToForSinglePost(String url) {
//        String str = Serenity.sessionVariableCalled("postsID");
        SerenityRest.given().pathParams("id", "aa");
        URL = url;
    }

    @When("send request GET single posts from id {string}")
    public void sendRequestGETSinglePostsFromId(String id) {
        SerenityRest.when().get(URL+"?access-token=3c2333def57e12a588eb567a9877a0bf629a6bc7e977432385b8d391445a689e");
    }

    @Given("set path to {string} for users post")
    public void setPathToForUsersPost(String url) {
        SerenityRest.given().pathParams("id", globalEnv.usersID);
        URL = url;
    }
}
