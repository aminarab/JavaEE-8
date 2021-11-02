package ir.amin.mavenbased.rest.samples;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class DebugExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
    	System.out.println("printStackTrace in DebugExceptionMapper " );
        exception.printStackTrace();
        return Response.serverError().entity(exception.getMessage()).build();
    } 
}