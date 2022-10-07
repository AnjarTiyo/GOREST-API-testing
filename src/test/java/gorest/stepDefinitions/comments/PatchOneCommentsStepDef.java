package gorest.stepDefinitions.comments;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;

public class PatchOneCommentsStepDef {
    public String URL;
    @Given("set path to PATCH one comment {string}")
    public void setPathToPostOneComments(String url){
        SerenityRest.given().baseUri(url);
        URL=url;
    }

    @And("set request body PATCH one comment to JSON data")
    public void setRequestBodyPATCHOneCommentToJSONData() {

    }

    @When("send request PATCH comments")
    public void sendRequestPATCHComments() {
        SerenityRest.when().patch(URL);
    }
}
