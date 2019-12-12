package in.kodecamp.cms.api.students;

import javax.ws.rs.core.UriInfo;

import in.kodecamp.cms.api.commons.Link;
import in.kodecamp.models.StudentEntity;

/**
 * StudentResource
 */
public class StudentResource extends Link {

  public StudentResource(UriInfo info, StudentEntity entity) {
    super(info, entity);
    put("name", entity.getName());
    put("address", entity.getAddress());
    put("created", entity.getCreatedOn());
    put("modifiedOn", entity.getModifiedOn());
    // put("user", new Link(getFullyQualifiedContextPath(info), todo.getUser()));
  }
}
