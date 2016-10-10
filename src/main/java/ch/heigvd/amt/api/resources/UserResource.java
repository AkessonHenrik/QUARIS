package ch.heigvd.amt.api.resources;

import ch.heigvd.amt.api.dto.UserDTO;
import ch.heigvd.amt.models.User;
import ch.heigvd.amt.services.UserManagerLocal;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
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
    private HttpServletRequest request;

    @Context
    private UriInfo uriInfo;

    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser() {
        return "test ok";
    }

    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO getUser(
            @PathParam(value="username") String username
    ) {
        // TODO use a serializer
        System.out.println(username);
        return new UserDTO(userManager.getUserbyName(username));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserDTO addUser(
            UserDTO user
    ) {
        userManager.addUser(user.getUsername(), user.getPassword(), request.getSession());

        response.setStatus(201);
        return user;
//        return "{\"status\": \"ok\"}";
    }
}
