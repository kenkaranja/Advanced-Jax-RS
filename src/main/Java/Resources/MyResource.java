package Resources;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/test")
@Singleton       //every Request Refers to the same instance hence the count is incremented
public class MyResource {
    private int count;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String testMethod() {
        count = count + 1;
        return "It's Working!!! This method wass called: " + count + " time(s).";
    }
}
