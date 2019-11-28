package in.kodecamp.security;

import java.security.Principal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

// this class will be utilized by the Lazy realm for checking the user and password
// sent to this by the accessed resource
@ApplicationScoped
public class AuthBean {

  private Map<String, String> userCredentials = new HashMap<>();
  private Map<String, List<String>> userRoles = new HashMap<>();

  public AuthBean() {
    System.out.println("########### AuthBean : Constructor");
    userCredentials.put("kodecamp", "kodecamp");
    userCredentials.put("kcamp", "kcamp");

    userRoles.put("kodecamp", Arrays.asList("admin", "user"));
    userRoles.put("kcamp", Arrays.asList("user"));
  }

  public Principal authenticate(final String username, String password) {
    System.out.println("########### AuthBean : authenticate : username : " + username + " Password : " + password);

    final String storedPwd = userCredentials.get(username);
    Principal principal = password.equals(storedPwd) ? createNewPrincipal(username) : null;
    System.out.println(" User has been verified : " + principal);
    return principal;

  }

  public boolean hasRole(final Principal principal, final String role) {
    final boolean isRoleFound = userRoles.get(principal.getName()).contains(role);
    System.out.println(String.format("%s has role %s : %b", principal, role, isRoleFound));
    return isRoleFound;
  }

  private Principal createNewPrincipal(final String name) {
    return new Principal() {
      @Override
      public String getName() {
        return name;
      }

      @Override
      public String toString() {
        return name;
      }
    };
  }
}
