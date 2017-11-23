package Resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.Calendar;
import java.util.Date;

@Path("/customMediaType")
public class CustomMediaType {
    @GET
    @Produces("text/shortdate")
    public Date testMethod() {
        return Calendar.getInstance().getTime();
    }
}
