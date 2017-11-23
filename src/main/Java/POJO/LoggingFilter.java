package POJO;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class LoggingFilter implements ContainerRequestFilter,ContainerResponseFilter {
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        System.out.println("Request Filter");
        System.out.println("Headers: " + containerRequestContext.getHeaders());

    }

    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
     System.out.println("Response Filter");
     System.out.println("Response HEaders: "+containerResponseContext.getHeaders());
    }
}
