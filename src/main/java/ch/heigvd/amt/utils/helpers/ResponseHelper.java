package ch.heigvd.amt.utils.helpers;

import javax.ws.rs.core.Response;

public class ResponseHelper {
    public static Response send(Response.Status status, Object object) {
        return Response.status(status).entity(object).build();
    }

    public static Response ok(Object object) {
        return Response.ok(object).build();
    }
}
