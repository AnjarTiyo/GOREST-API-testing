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
                .headers("Authorization", "Bearer "+value);
    }
}
