package exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now().toString());
        errorResponse.put("message", exception.getMessage());

        if (exception instanceof NotFoundException) {
            errorResponse.put("status", 404);
            errorResponse.put("error", "Not Found");
            return Response.status(Response.Status.NOT_FOUND).entity(errorResponse).build();
        } else if (exception instanceof ValidationException) {
            errorResponse.put("status", 400);
            errorResponse.put("error", "Bad Request");
            return Response.status(Response.Status.BAD_REQUEST).entity(errorResponse).build();
        } else if (exception instanceof DatabaseException) {
            errorResponse.put("status", 500);
            errorResponse.put("error", "Internal Server Error");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorResponse).build();
        } else {
            errorResponse.put("status", 500);
            errorResponse.put("error", "Unexpected Error");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorResponse).build();
        }
    }
}