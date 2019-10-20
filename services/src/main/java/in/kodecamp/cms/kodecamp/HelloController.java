package in.kodecamp.cms.kodecamp;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 */
@Path("/hello")
@Singleton
public class HelloController {

  @PersistenceContext
  private EntityManager em;

  @GET
  public String sayHello() {
    System.out.println("Updated 01");
    System.out.println("Updated 01");
    System.out.println("Updated 01");
    System.out.println("Hello world" + em.getClass());
    return "Hello World";
  }
}
