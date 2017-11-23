package Resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("{pathParam}/test1")
public class MyResource1 {
    private @PathParam("pathParam")
    String pathParamExample;
    private @QueryParam("query")
    String queryParamExample;


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String testMethod() {
        return "It's Working!!! PathParam Used " + pathParamExample + " and QueryParam Used is " + queryParamExample ;
    }
}
