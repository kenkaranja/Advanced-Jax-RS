package Client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class InvocationDemo {
    public Invocation prepareRequestForMessageByYear(int year) {
        Client client = ClientBuilder.newClient();
        //uri= /messages?year=2017
        return client.target("http://localhost:9081/AdvancedRest/webapi/")
                .path("messages")
                .queryParam("year", year)
                .request(MediaType.APPLICATION_JSON)
                .buildGet(); //Return an Invocation object - request that is ready to go


    }

    public static void main(String... args) {
        InvocationDemo invocationDemo = new InvocationDemo();
        Invocation invocation = invocationDemo.prepareRequestForMessageByYear(2017);
        Response response = invocation.invoke();
        System.out.println(response.getStatus());
    }
}
