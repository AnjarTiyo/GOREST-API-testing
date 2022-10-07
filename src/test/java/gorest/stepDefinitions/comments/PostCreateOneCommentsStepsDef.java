package gorest.stepDefinitions.comments;

import gorest.env.globalEnv;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import net.thucydides.core.annotations.Managed;


import java.io.File;
import java.util.HashMap;

public class PostCreateOneCommentsStepsDef {
    @Managed
    Lorem lorem = LoremIpsum.getInstance();
    public String URL;

    @Given("set path to Post one comment {string}")
    public void setPathToPostOneComments(String url){
        URL=url;
    }

    @And("set request body to JSON data")
    public void setRequestBodyToJSONData() {
        HashMap<String, Object> json = new HashMap<String, Object>();
        String s1 = lorem.getNameMale();
        String s2 = lorem.getEmail();
        String s3 = lorem.getWords(3,8);
        json.put("name", s1);
        json.put("email", s2);
        json.put("body", s3);
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @When("send request POST comments")
    public void sendRequestPOSTComments() {
        SerenityRest.given().pathParams("postsID", globalEnv.postsID)
                .when().post(URL+"?access-token=7ac1b26f8a04f41c988a284ffa38a91b0007d46c9f3374755d15bfeb5fd70e81");
    }

    @Then("API should return {int} Created")
    public void apiShouldReturnCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

//    @Then("API should return {int} Unprocessable Entity")
//    public void shouldReturnUnprocessableEntity(int unprocessable) {
//        SerenityRest.then().statusCode(unprocessable);
//    }
}
