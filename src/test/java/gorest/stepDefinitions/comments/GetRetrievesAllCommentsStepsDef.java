package gorest.stepDefinitions.comments;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;

import java.io.File;

public class GetRetrievesAllCommentsStepsDef {

    public String URL;

    //@comments-008
    @Given("set path to get retrieves all comment {string}")
        public void setPathTo(String url){
        SerenityRest.given().baseUri(url);
        URL=url;
    }

    @When("send request GET comments")
    public void sendRequestGETComments() {
        SerenityRest.when().get(URL);
    }

    @Then("API should return {int} OK")
    public void apiShouldReturnOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("assert response body to GET all comments json schema")
    public void assertResponseBodyToGETAllCommentsJsonSchema() {
        File json = new File("src/test/resources/JSON/JsonSchema/getAllCommentsSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //@comments-009
    @Then("API should return {int} Not Found")
    public void apiShouldReturnNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }
    //@comments-010
    @And("assert response GET all users comments with name to json schema")
    public void assertResponseGETAllUsersCommentsWithNameToJsonSchema() {
        File json = new File("src/test/resources/JSON/JsonSchema/getAllUsersCommentsWithNameSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    //@comments-012
    @And("assert response GET all users comments with body contains number to json schema")
    public void assertResponseGETAllUsersCommentsWithBodyContainsNumberToJsonSchema() {
        File json = new File("src/test/resources/JSON/JsonSchema/getAllUsersCommentsWithBodyContainsNumberSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    //@comments-014
    @And("assert response GET all users comments within valid page to json schema")
    public void assertResponseGETAllUsersCommentsWithinValidPageToJsonSchema() {
        File json = new File("src/test/resources/JSON/JsonSchema/getAllUsersCommentsWithinValidPageSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
    //@comments-015
    @And("assert response GET all users comments within invalid page to json schema")
    public void assertResponseGETAllUsersCommentsWithinInvalidPageToJsonSchema() {
        File json = new File("src/test/resources/JSON/JsonSchema/getAllUsersCommentsWithinInvalidPageToSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
