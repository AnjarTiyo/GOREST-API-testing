package gorest.step;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import java.io.File;
import java.util.HashMap;

public class UsersAPI {

//    Lorem lorem = LoremIpsum.getInstance();
//    public static final String URL = "https://gorest.co.in/public/v1/users";

    public static final String DIR = System.getProperty("user.dir");
    public static final String JSON_FILE = DIR+"/src/test/resources/json";

    @Step("Set request body post to json data")
    public void setRequestBodyPostToJsonData(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }




}
