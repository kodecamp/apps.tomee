package in.kodecamp.cms.api.students;

import javax.ws.rs.core.UriInfo;

import in.kodecamp.core.resources.Link;
import in.kodecamp.cms.api.students.StudentEntity;

/**
 * StudentResource
 */
public class StudentResource extends Link {

  public StudentResource(final UriInfo info, final StudentEntity entity) {
    super(info, entity);
    put("name", entity.getName());
    put("address", entity.getAddress());
    put("createdOn", entity.getCreatedOn());
    put("modifiedOn", entity.getModifiedOn());
    // put("user", new Link(getFullyQualifiedContextPath(info), todo.getUser()));
  }
}
