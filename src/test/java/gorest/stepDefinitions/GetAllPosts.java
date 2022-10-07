package gorest.stepDefinitions;

import gorest.step.GorestAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Managed;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetAllPosts {
    @Managed
    public String URL;

    @Given("set path to {string}")
    public void setPathTo(String url) {
        URL = url;
    }

    @When("send request GET posts")
    public void sendRequestGETPosts() {
        SerenityRest.when().get(URL);
    }

    @And("set Header keys {string} values to {int}")
    public void setHeaderKeysValuesTo(String keys, int values) {
        SerenityRest.given().headers(keys, values);
    }

    @And("assert response body {string} equals {int}")
    public void assertResponseBodyEquals(String var, int val) {
        SerenityRest.then().body("meta.pagination." + var, equalTo(val));
    }

    @And("assert response body {string} contains {string}")
    public void assertResponseBodyContains(String var, String val) {
        SerenityRest.then().body(containsString(val));
    }


    @Given("set path to {string} on {string} {string}")
    public void setPathToOnPage(String url, String param, String value) {
        int t = Integer.parseInt(value);
        SerenityRest.given().pathParams(param, t);
        URL = url;
    }
}
