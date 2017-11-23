package Client;

import messenger.Model.Message;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class GenericDemo {
    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();
        //uri= /messages?year=2017
        List<Message> messages = client.target("http://localhost:9081/AdvancedRest/webapi/")
                .path("messages")
                .queryParam("year", 2017)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Message>>() {}); //{} is an inline implementation
        for (Message message :messages){
            System.out.println(message.getMessage());
        }
    }
}
