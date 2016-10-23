package ch.heigvd.amt.api.resources;

import ch.heigvd.amt.api.dto.ErrorDTO;
import ch.heigvd.amt.api.dto.UserDTO;
import ch.heigvd.amt.models.User;
import ch.heigvd.amt.services.dao.UserManagerLocal;
import ch.heigvd.amt.utils.PATCH;
import ch.heigvd.amt.utils.helpers.ResponseHelper;
import ch.heigvd.amt.utils.validations.UserValidation;

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
    public Response getUsers(
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
            @PathParam(value="username") final String username
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
            final UserDTO user
    ) {
        if (!UserValidation.username(user.getUsername())) {
            return ResponseHelper.send(
                    Response.Status.BAD_REQUEST,
                    new ErrorDTO("INVALID_USERNAME", "Username must be more than 6 characters")
            );
        }

        if (!UserValidation.password(user.getPassword())) {
            return ResponseHelper.send(
                    Response.Status.BAD_REQUEST,
                    new ErrorDTO("INVALID_PASSWORD")
            );
        }

        if (!UserValidation.email(user.getEmail())) {
            return ResponseHelper.send(
                    Response.Status.BAD_REQUEST,
                    new ErrorDTO("INVALID_EMAIL")
            );
        }

        if (userManager.addUser(new User(user.getEmail(), user.getUsername(), user.getPassword()))) {
            return ResponseHelper.send(Response.Status.CREATED, user);
        }

        return Response.serverError().build();
    }

    @PATCH
    @Path("/{username}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response patchRow(
            @PathParam("username") final String username,
            final UserDTO user
    ) {
        if (!userManager.exists(username)) {
            // User does not exists
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        if (user.getUsername() != null && userManager.exists(user.getUsername())) {
            return Response.status(Response.Status.CONFLICT).build();
        }

        User oldUser = userManager.getUserByUsername(username);

        if (user.getUsername() != null) {
            oldUser.setUsername(user.getUsername());
        }

        if (user.getEmail() != null) {
            oldUser.setEmail(user.getEmail());
        }

        if (user.getPassword() != null) {
            oldUser.setPassword(user.getPassword());
        }

        if (userManager.updateByUsername(username, oldUser)) {
            return Response.ok().build(); // CHECK
        }

        return Response.serverError().build();
    }

    @DELETE
    @Path("/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(
            @PathParam(value="username") final String username
    ) {
        if (userManager.exists(username)) {
            if (userManager.deleteByUsername(username)) {
                return Response.ok().build();
            }

            // User cannot be deleted
            return Response.serverError().build();
        }

        // User does not exists
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
