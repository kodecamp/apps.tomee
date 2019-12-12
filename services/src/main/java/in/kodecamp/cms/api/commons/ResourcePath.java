package in.kodecamp.cms.api.commons;

import in.kodecamp.models.BaseEntity;
import in.kodecamp.models.StudentEntity;

public enum ResourcePath {

  ResourcePath(Link.STUDENTS, StudentEntity.class);

  private final String path;
  private final Class<? extends BaseEntity> associatedClass;

  // private constructor
  private ResourcePath(String path, Class<? extends BaseEntity> clazz) {
    this.path = path;
    this.associatedClass = clazz;
  }

  public static ResourcePath forClass(Class<? extends BaseEntity> clazz) {
    for (ResourcePath rp : values()) {
      // Cannot use equals because of hibernate proxied object
      // Cannot use instanceof because type not fixed at compile time
      if (rp.associatedClass.isAssignableFrom(clazz)) {
        return rp;
      }
    }
    throw new IllegalArgumentException("No ResourcePath for class '" + clazz.getName() + "'");
  }

  public String getPath() {
    return path;
  }

  public Class<? extends BaseEntity> getAssociatedClass() {
    return associatedClass;
  }
}
