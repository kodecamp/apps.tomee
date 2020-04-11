package in.kodecamp.core.resources;

/**
 * Link
 */
import javax.ws.rs.core.UriInfo;
import java.util.LinkedHashMap;

import in.kodecamp.core.entities.BaseEntity;

public class Link extends LinkedHashMap<String, Object> {

  private static final long serialVersionUID = 1L;

  public static final String PATH_SEPARATOR = "/";

  /* public static final String STUDENTS = PATH_SEPARATOR + "students"; */
  /* public static final String USERS = PATH_SEPARATOR + "users"; */

  public Link(UriInfo info, BaseEntity entity) {
    this(getFullyQualifiedContextPath(info), entity);
  }

  public Link(String fqBasePath, BaseEntity entity) {
    String href = createHref(fqBasePath, entity);
    put("href", href);
  }

  public Link(UriInfo info, String subPath) {
    this(getFullyQualifiedContextPath(info), subPath);
  }

  public Link(String fqBasePath, String subPath) {
    String href = fqBasePath + subPath;
    put("href", href);
  }

  protected static String getFullyQualifiedContextPath(UriInfo uriInfo) {
    String fq = uriInfo.getBaseUri()
        .toString();
    if (fq.endsWith("/")) {
      return fq.substring(0, fq.length() - 1);
    }
    return fq;
  }

  protected String createHref(String fqBasePath, BaseEntity entity) {
    StringBuilder sb = new StringBuilder(fqBasePath);
    String path = ResourcePath.getPath(entity.getClass()
        .getName());
    sb.append(path)
        .append(PATH_SEPARATOR)
        .append(entity.getId());
    return sb.toString();
  }

  public String getHref() {
    return (String) get("href");
  }

}
