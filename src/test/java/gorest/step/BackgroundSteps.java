package gorest.step;

import gorest.env.globalEnv;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Managed;

public class BackgroundSteps {
    @Managed
    globalEnv env;

    @Given("BASE_URL is set to {string}")
    public void setEnv(String value){
        env.BASE_URL = value;
    }
    @And("usersEndpoint is set to {string}")
    public void usersendpointIsSetTo(String value) {
        env.usersEndpoint = value;
    }

    @And("postsEndpoint is set to {string}")
    public void postsendpointIsSetTo(String value) {
        env.postsEndpoint = value;
    }

    @And("commentsEndpoint is set to {string}")
    public void isSetTo(String value) {
        env.commentEndpoint = value;
    }

    @Given("bearerToken is set to {string}")
    public void bearertokenIsSetTo(String value) {
        SerenityRest.given()
                .headers("Authorization", "Bearer 32441f3f8fe63c08acb2d18fd19d853ba2c24cc037cb7c72ad65ce40a382010c");
    }

    @Given("BearerToken is set to {string}")
    public void tokenIsSetTo(String arg0) {
        SerenityRest.given()
                .headers("Authorization", "Bearer 7ac1b26f8a04f41c988a284ffa38a91b0007d46c9f3374755d15bfeb5fd70e81");

    }
}
