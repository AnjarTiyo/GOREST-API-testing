package gorest.env;

import gorest.step.gorestAPI;
import net.thucydides.core.annotations.Managed;

public class globalEnv {
    @Managed
    gorestAPI API;

    public String BASE_URL;
    public String usersEndpoint;
    public String postsEndpoint;
    public String commentEndpoint;
    public String bearerToken = "3c2333def57e12a588eb567a9877a0bf629a6bc7e977432385b8d391445a689e";
    public String usersID = API.getValue("usersID");
    public String postsID = API.getValue("postsID");

}
