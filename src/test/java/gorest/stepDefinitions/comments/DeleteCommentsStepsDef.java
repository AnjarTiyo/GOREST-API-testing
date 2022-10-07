package gorest.stepDefinitions.comments;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;

public class DeleteCommentsStepsDef {
    public String URL;
    @When("send request DEL comments")
    public void sendRequestGETComments() {
        SerenityRest.when().delete(URL);
    }

    @Then("API should return {int} No Content")
    public void shouldReturnNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }
}
