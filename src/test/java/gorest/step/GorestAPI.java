package gorest.step;

import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.remote.Response;

import java.io.File;

import static io.restassured.RestAssured.given;

public class GorestAPI {

    public String URL;
    public static final String DIR = System.getProperty("user.dir");
    public final String JSON_SCHEMA = DIR+"/src/test/resources/json/schema/";
    public void getValue(String param){
        //return SerenityRest.then().body().extract().path(param);
    }
    public void validateSchema(String file){
        File json = new File(JSON_SCHEMA+"/getAllPosts.json");
        SerenityRest.then().assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}