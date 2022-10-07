package gorest.step;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import gorest.env.globalEnv;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.remote.Response;

import java.io.File;
import java.util.HashMap;

import static gorest.env.globalEnv.postsID;
import static io.restassured.RestAssured.given;

public class GorestAPI {

    public String URL;
    public static final String DIR = System.getProperty("user.dir");
    public final String JSON_SCHEMA = DIR+"/src/test/resources/json/schema/";
    public String POST_NEW_USER = "https://gorest.co.in/public/v1/users";
    public void validateSchema(String file){
        File json = new File(JSON_SCHEMA+"/getAllPosts.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    public void safeFailDelete(String id){
        SerenityRest.when().delete("https://gorest.co.in/public/v1/posts/"+id);
    }

    public void fullNewPosts(){
        Lorem lorem = LoremIpsum.getInstance();
        HashMap<String, Object> json = new HashMap<String, Object>();
        String s1 = lorem.getWords(3,5);
        String s2 = lorem.getWords(5,20);
        json.put("title", "new title");
        json.put("body", "new body");
        SerenityRest.given()
                    .contentType(ContentType.JSON)
                    .body(json)
                .when()
                    .post(URL+"?access-token=3c2333def57e12a588eb567a9877a0bf629a6bc7e977432385b8d391445a689e");
        globalEnv.usersID = SerenityRest.then().extract().path("data.id");
    }
}