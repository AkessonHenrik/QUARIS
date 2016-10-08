package ch.heigvd.amt.api.resources;

import ch.heigvd.amt.model.User;
import ch.heigvd.amt.services.UserManager;
import ch.heigvd.amt.services.UserManagerLocal;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Stateless
@Path("/users")
public class UserResource extends APIResource {
    @EJB
    private UserManagerLocal userManager;

    @Context
    private HttpServletResponse response;

    @Context
    private UriInfo uriInfo;

    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser(
            @PathParam(value="username") String username
    ) {
        // TODO use a serializer
        System.out.println(username);
        return userManager.getUserbyName(username).toString();
//        return "Get a user with /users/{userId}";
    }

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getUsers() {
//        return "Get a user with /users/{userId}";
//    }


//    @GET
//    @Path("/{userId}/id")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getUser(
//            @PathParam(value="userId") Long userId
//    ) {
////        userManager.getUserbyName()
//        return "Get a user with /users/{userId}";
//    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addUser(User user) {
        return "add new user";
    }
}
