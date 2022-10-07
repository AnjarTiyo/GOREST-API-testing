package gorest.stepDefinitions.comments;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import gorest.env.globalEnv;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Managed;

import java.util.HashMap;

public class PutComments {
    @Managed
    Lorem lorem = LoremIpsum.getInstance();
    public String URL;
    @Given("set path to PUT one comment {string}")
    public void setPathToPostOneComments(String url){
        URL=url;
    }


    @When("send request PUT comments")
    public void sendRequestPUTComments() {
//        HashMap<String, Object> json = new HashMap<String, Object>();
//        String s1 = lorem.getNameMale();
//        String s2 = lorem.getEmail();
//        String s3 = "new body";
//        json.put("name", s1);
//        json.put("email", s2);
//        json.put("body", s3);
//        SerenityRest.given()
//                .contentType(ContentType.JSON)
//                .body(json);
//        SerenityRest.when().put(URL+"?access-token=10d553d5ddff8744213fde67295563f6ac0a2d296b96f29ad004aa92bdd5ce2b");
    }

    @And("set request body PUT one comment to JSON data")
    public void setRequestBodyPUTOneCommentToJSONData() {
//        HashMap<String, Object> json = new HashMap<String, Object>();
//        String s1 = lorem.getNameMale();
//        String s2 = lorem.getEmail();
//        String s3 = "new body";
//        json.put("name", s1);
//        json.put("email", s2);
//        json.put("body", s3);
//        SerenityRest.given()
//                .contentType(ContentType.JSON)
//                .body(json);

    }

    @And("API should return {int} OK for comment update")
    public void apiShouldReturnOKForCommentUpdate(int ok) {
    }
}
