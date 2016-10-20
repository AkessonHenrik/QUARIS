package ch.heigvd.amt.api.resources;

import ch.heigvd.amt.api.dto.UserDTO;
import ch.heigvd.amt.models.User;
import ch.heigvd.amt.services.dao.UserManagerLocal;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.sql.SQLException;

@Stateless
@Path("/users")
public class UserResource extends APIResource {
    @EJB
    private UserManagerLocal userManager;

//    @Context
//    private HttpServletResponse response;

    @Context
    private HttpServletRequest request;

    @Context
    private UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(
    ) {
        try {
            return Response.ok(userManager.getAll().stream().map(u -> new UserDTO(u)).toArray()).build();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Response.serverError().build();
    }

    @GET
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(
            @PathParam(value="username") String username
    ) {
        if (userManager.exists(username)) {
            return Response.ok(new UserDTO(userManager.getUserByUsername(username))).build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(
            UserDTO user
    ) {
        if (userManager.addUser(new User(user.getEmail(), user.getUsername(), user.getPassword()))) {
            return Response.ok(user).status(Response.Status.CREATED).build();
        }

        return Response.serverError().build();

//        return "{\"status\": \"ok\"}";
    }
}
