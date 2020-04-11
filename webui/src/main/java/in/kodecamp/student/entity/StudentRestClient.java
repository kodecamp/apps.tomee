package in.kodecamp.student.entity;

import java.util.LinkedHashMap;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 * StudentRestClient
 */
@Path("students")
@RegisterRestClient
public interface StudentRestClient {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public LinkedHashMap<String, Object> students(@HeaderParam("Authorization") String authorization,
      @QueryParam("expand") boolean isExpanded, @QueryParam("offset") int offset,
      @QueryParam("size") int size);

}
