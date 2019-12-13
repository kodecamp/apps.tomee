package in.kodecamp.core.resources;

import in.kodecamp.core.entities.BaseEntity;
import java.util.Map;
import java.util.HashMap;
import java.util.Properties;
import java.util.Enumeration;
import java.io.*;

public final class ResourcePath {

  private static final String DEFAULT_MAPPING_FILE="entitypath-mappings";
  private static  Map<String,String> entityPathMap = new HashMap<>();

  static {
     loadPathMappings();
  }

  private static void loadPathMappings() {
    System.out.println("####################### Loaded Path Mappings ######################");
    Properties props = new Properties();
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    try {
      InputStream in = classLoader.getResourceAsStream("/"+DEFAULT_MAPPING_FILE+".properties");
      props.load(in);
      Enumeration e = props.propertyNames();

      while (e.hasMoreElements()) {
        String key = String.valueOf(e.nextElement());
        String value = String.valueOf(props.getProperty(key));
        System.out.println(key + " ::  " + value);
        entityPathMap.put(key,value);
      }
      in.close();
    } catch(IOException ioException) {
      System.out.println("################## Unable to load entitypath-mappings ################");
    }
  }

  public static String getPath(final String entityName) {
    String path = entityPathMap.get(entityName);
    System.out.println("### Mapped Path Entity : " + entityName + ", Path : "+ path);
    return path;
  }

}
