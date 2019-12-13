package in.kodecamp.core.resources;

import in.kodecamp.core.entities.BaseEntity;
import java.util.Map;
import java.util.HashMap;
import java.util.Properties;
import java.util.Enumeration;
import java.io.*;

public final class ResourcePath {

  // ResourcePath(Link.STUDENTS, StudentEntity.class);
  private static  Map<String,String> entityPathMap = new HashMap<>();

  static {
     loadPathMappings();
  }

  private static void loadPathMappings() {
    System.out.println("####################### loadPathMappings ######################");
    Properties props = new Properties();
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    try {
      InputStream in = classLoader.getResourceAsStream("/entitypath-mappings.properties");
      props.load(in);
      Enumeration e = props.propertyNames();

      System.out.println("=============================================================");
      while (e.hasMoreElements()) {
        String key = String.valueOf(e.nextElement());
        String value = String.valueOf(props.getProperty(key));
        System.out.println(key + " ::  " + value);
        entityPathMap.put(key,value);
      }
      System.out.println("=============================================================");
      in.close();
    } catch(IOException ioException) {
      System.out.println("################## Unable to load entitypath-mappings ################");
    }
  }

  // private final String path;
  // private final Class<? extends BaseEntity> associatedClass;

  // private constructor
  // private ResourcePath(String path, Class<? extends BaseEntity> clazz) {
    // this.path = path;
    // this.associatedClass = clazz;
  // }

  // public static ResourcePath forClass(Class<? extends BaseEntity> clazz) {
    // for (ResourcePath rp : values()) {
      // Cannot use equals because of hibernate proxied object
      // Cannot use instanceof because type not fixed at compile time
      // if (rp.associatedClass.isAssignableFrom(clazz)) {
        // return rp;
      // }
    // }
    // throw new IllegalArgumentException("No ResourcePath for class '" + clazz.getName() + "'");
  // }

  public static String getPath(final String entityName) {
    System.out.println("##################### Path for "+ entityName +" #################");
    String path = entityPathMap.get(entityName);
    System.out.println("############################ Path : " + path + "################");
    return path;
  }

  // public Class<? extends BaseEntity> getAssociatedClass() {
    // return associatedClass;
  // }
}
