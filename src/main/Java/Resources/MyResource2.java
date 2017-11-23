package Resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Calendar;
import java.util.Date;

@Path("/messageBodyWriter")
public class MyResource2 {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Date testMethod() {
        return Calendar.getInstance().getTime();
    }
}
