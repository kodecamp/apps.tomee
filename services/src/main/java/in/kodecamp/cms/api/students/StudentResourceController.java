package in.kodecamp.cms.api.students;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.eclipse.microprofile.jwt.JsonWebToken;
import in.kodecamp.cms.api.commons.PathConstants;
import in.kodecamp.core.entities.BaseEntity;
import in.kodecamp.core.exceptions.UnknownResourceException;
import in.kodecamp.core.resources.BaseResourceController;
import in.kodecamp.core.resources.CollectionResource;

/**
 * StudentsResource
 */
@Path(PathConstants.PATH_STUDENTS)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResourceController extends BaseResourceController<StudentResource> {

  @Inject
  private JsonWebToken token;

  @Inject
  private Principal principal;

  /**
   * Constructor
   */
  public StudentResourceController() {
    System.out.println("StudentResource : Constructor");
  }

  private final String className = this.getClass().getName() + " : ";

  @Inject
  private StudentBO studentBo;

  @PostConstruct
  public void init() {
    final String msg = this.className + "Init : StudentBo : " + this.studentBo;
    System.out.println(msg);
  }

  @GET
  @RolesAllowed({"ADMIN", "PRINCIPAL", "TEACHER"})
  public CollectionResource list(@Context UriInfo info,
      @DefaultValue("false") @QueryParam("expand") boolean isExpanded,
      @DefaultValue("0") @QueryParam("offset") int offset,
      @DefaultValue("100") @QueryParam("size") int size) {
    System.out.println(
        "------------------------------------- Security Details -----------------------------------------");
    System.out.println("Principal " + principal.getName());
    System.out.println("JsonWebToken : " + this.token);
    System.out.println(
        "------------------------------------- Security Details -----------------------------------------");
    System.out.println(this.className + "getAll");

    System.out.println("isExpanded : " + isExpanded + ", offset: " + offset + ", size: " + size);
    List<StudentEntity> resultList = studentBo.getAllActive();
    return super.createCollectionResource(info, PathConstants.PATH_STUDENTS, resultList,
        isExpanded);
  }

  @GET
  @Path("/{id}")
  @RolesAllowed({"ADMIN", "PRINCIPAL", "TEACHER", "STUDENT"})
  public StudentResource getBy(@Context UriInfo uriInfo, @PathParam("id") long id) {
    System.out.println(this.className + "getBy(id) -> id : " + id);
    StudentEntity fe = studentBo.getBy(id);
    if (fe == null) {
      throw new UnknownResourceException();
    }
    return new StudentResource(uriInfo, fe);
  }

  @PUT
  @Path("/{id}")
  public Response update(@Context UriInfo uriInfo, @PathParam("id") long id,
      final Map fieldValueMap) {
    System.out.println(this.className + "update at id : " + id + " with -> " + fieldValueMap);
    StudentEntity foundEntity = this.studentBo.getBy(id);

    if (foundEntity == null) {
      throw new UnknownResourceException();
    }
    // this can be automated for each entity
    if (fieldValueMap.containsKey("name")) {
      foundEntity.setName(String.valueOf(fieldValueMap.get("name")));
    }

    if (fieldValueMap.containsKey("address")) {
      foundEntity.setAddress(String.valueOf(fieldValueMap.get("address")));
    }
    foundEntity = this.studentBo.update(foundEntity);
    return Response.ok(new StudentResource(uriInfo, foundEntity)).build();
  }

  @POST
  public Response create(final @Context UriInfo uriInfo, final StudentEntity newStudent) {
    System.out.println(this.className + "create : " + newStudent);
    final StudentEntity newEntity = this.studentBo.createNew(newStudent);
    return created(new StudentResource(uriInfo, newEntity));
  }

  @DELETE
  @Path("/{id}")
  public Response deleteBy(@PathParam("id") final long id) {
    StudentEntity entity = this.studentBo.deleteBy(id);
    if (entity == null) {
      throw new UnknownResourceException();
    }
    return Response.ok("Record Deleted Successfully").build();
  }

  @Override
  protected StudentResource createResource(UriInfo uriInfo, BaseEntity entity) {
    return new StudentResource(uriInfo, (StudentEntity) entity);
  }

}
