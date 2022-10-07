package gorest.stepDefinitions.comments;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;

public class PutComments {
    public String URL;
    @Given("set path to PUT one comment {string}")
    public void setPathToPostOneComments(String url){
        SerenityRest.given().baseUri(url);
        URL=url;
    }


    @When("send request PUT comments")
    public void sendRequestPUTComments() {
        SerenityRest.when().put(URL);
    }

    @And("set request body PUT one comment to JSON data")
    public void setRequestBodyPUTOneCommentToJSONData() {

    }
}
