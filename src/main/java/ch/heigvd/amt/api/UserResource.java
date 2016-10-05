package ch.heigvd.amt.api;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

// The Java class will be hosted at the URI path "/helloworld"
@Stateless
@Path("/users")
public class UserResource {
//    @EJB
//    private UserManager um;

    @Context
    private HttpServletResponse response;

    @Context
    private UriInfo uriInfo;


    // The Java method will process HTTP GET requests
    @GET
//    @Path("a")
//    @Consumes("application/json")
//    @Produces(MediaType.APPLICATION_JSON)
    public String getUsers() {
        System.out.println("TEST");

        return "Hello World";
    }
}
