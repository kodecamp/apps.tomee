package in.kodecamp.cms.kodecamp;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 */
@Path("/hello")
@Stateless
public class HelloController {

  @PersistenceContext
  private EntityManager em;

  @GET
  public String sayHello() {
    System.out.println("Updated 01 02 03");
    System.out.println("Hello world" + em.getClass());
    return "Hello World";
  }
}
