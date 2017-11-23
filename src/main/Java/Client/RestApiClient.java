package Client;


import com.sun.org.apache.regexp.internal.RE;
import messenger.Model.Message;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestApiClient {
    public static void main(String... args) {
        //Client is an interface
        Client client = ClientBuilder.newClient();
//        WebTarget target = client.target("http://localhost:9081/AdvancedRest/webapi/messages/1");
//        Invocation.Builder builder = target.request();
//        Response response = builder.get();
//        Message message = response.readEntity(Message.class);

        //this can also be done as
        Response response = client.target("http://localhost:9081/AdvancedRest/webapi/messages/1")
                .request(MediaType.APPLICATION_JSON)
                .get();
        Message message = response.readEntity(Message.class);
        System.out.println(message.getMessage());

        //this can also be done as
        Message message1 = client.target("http://localhost:9081/AdvancedRest/webapi/messages/2")
                .request(MediaType.APPLICATION_JSON)
                .get(Message.class);
        System.out.println(message1.getMessage());
        System.out.println(message1.getAuthor());

        //Best Practices in building a  Restclient
        //1.Using the base url
        WebTarget baseTarget = client.target("http://localhost:9081/AdvancedRest/webapi/");
        WebTarget messagesTarget = baseTarget.path("messages");
        WebTarget singleMessageTarget = messagesTarget.path("{msgId}");

        Message message2 = singleMessageTarget
                .resolveTemplate("msgId", "2")
                .request(MediaType.APPLICATION_JSON)
                .get(Message.class);
        System.out.println("This is messageid " + message2.getId() + ": " + message2.getMessage());

        //PostRequest
        Message newMessage = new Message(3, "This is a message from the Client", "Ken karanja");
        Response postResponse = messagesTarget.request().post(Entity.json(newMessage));


        if (postResponse.getStatus() != 201) {
            System.out.println("Error");
        }
        //readEntity unwraps the response
        Message createdMessage = postResponse.readEntity(Message.class);
        System.out.println(createdMessage.getMessage());
    }
}
