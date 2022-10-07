package gorest.stepDefinitions.users;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import gorest.env.UsersResponses;
import gorest.env.globalEnv;
import gorest.step.UsersAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Managed;

import java.io.File;
import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;

public class PutStepDef {

    @Managed
    UsersAPI usersAPI;
    public String URL;
    Lorem lorem = LoremIpsum.getInstance();

    //PUT UPDATE USER [USERS-013]
    @Given("set path update to {string}")
    public void setPathUpdateTo(String url){
        URL = url;
    }
    @And("set request body put to valid json data")
    public void setRequestBodyPutToValidJsonData() {
        HashMap<String, Object> json = new HashMap<String, Object>();
        String s1 = "put update name";
        String s2 = lorem.getFirstName()+"@email.com";
        String s3 = "male";
        String s4 = "active";
        json.put("name", s1);
        json.put("email", s2);
        json.put("gender", s3);
        json.put("status", s4);
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .pathParams("id", globalEnv.usersID);
    }
    @When("send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(URL+"?access-token=3c2333def57e12a588eb567a9877a0bf629a6bc7e977432385b8d391445a689e");
    }
    @And("response body should contain name {string} gender {string} email {string} status {string} and id {string}")
    public void responseBodyShouldContainNameGenderEmailStatus(String name, String gender, String email, String status, String id) {
        SerenityRest.then()
                .body(UsersResponses.NAME,equalTo(name))
                .body(UsersResponses.GENDER,equalTo(gender))
                .body(UsersResponses.EMAIL,equalTo(email))
                .body(UsersResponses.STATUS,equalTo(status))
                .body(UsersResponses.ID,equalTo(id));
    }
    @And("put update user json schema")
    public void putUpdateUserJsonSchema() {
        File json = new File(UsersAPI.JSON_FILE+"/schema/putUpdateUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("put update unavailable user json schema")
    public void putUpdateUnavailableUserJsonSchema() {
        File json = new File(UsersAPI.JSON_FILE+"/schema/putUpdateUnavailableUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("set request body put to invalid json data")
    public void setRequestBodyPutToInvalidJsonData() {
        HashMap<String, Object> json = new HashMap<String, Object>();
        String s1 = "put update name";
        String s3 = "male";
        String s4 = "active";
        json.put("name", s1);
        json.put("gender", s3);
        json.put("status", s4);
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json)
                .pathParams("id", globalEnv.usersID);
    }
}
