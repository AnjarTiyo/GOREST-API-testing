package gorest.stepDefinitions.users;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;

public class DeleteStepDef {
    public String URL;
    @Given("set path delete to {string}")
    public void setPathDeleteTo(String url){
        URL = url;
    }

    @When("send request delete user from id {string}")
    public void sendRequestDeleteUserFromId(String id) {
        SerenityRest.when().delete(URL + "?access-token=7ac1b26f8a04f41c988a284ffa38a91b0007d46c9f3374755d15bfeb5fd70e81");
    }
    @When("send request delete user from invalid {string}")
    public void sendRequestDeleteUserFromInvalid(String id) {
        SerenityRest.when().delete(URL + "?access-token=7ac1b26f8a04f41c988a284ffa38a91b0007d46c9f3374755d15bfeb5fd70e81");

    }
    @Then("should return {int} no content")
    public void shouldReturnNoContent(int nocontent) {
        SerenityRest.then().statusCode(nocontent);
    }


}
