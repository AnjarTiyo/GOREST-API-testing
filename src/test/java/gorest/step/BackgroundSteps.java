package gorest.step;

import gorest.env.globalEnv;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Managed;

public class BackgroundSteps {
    @Managed
    globalEnv env;
    @Given("{string} is set to{string}")
    public void setEnv(String param, String value){
    }
}
