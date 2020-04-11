package in.kodecamp.security;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;

/**
 * UserBean
 */
@SessionScoped
@Named("user")
public class LoggedInUser implements Serializable {

  private static final long serialVersionUID = 1L;

  @Inject
  private HttpServletRequest httpRequest;
  private String id;
  private String tokenId;
  private String name;
  private String email;
  private String token;
  private String profile;
  private String picture;
  private String phoneNumber;
  private String refreshToken;
  private Set<String> roles = new HashSet<>();
  private String scope;

  private boolean admin;

  @PostConstruct
  public void init() {
    KeycloakSecurityContext securityContext =
        (KeycloakSecurityContext) httpRequest.getAttribute(KeycloakSecurityContext.class.getName());

    System.out.println("securityContext : " + securityContext);
    System.out.println("Name : " + securityContext.getToken().getName());
    this.tokenId = securityContext.getIdToken().getId();
    this.token = securityContext.getIdTokenString();
    this.name = securityContext.getIdToken().getName();
    this.email = securityContext.getIdToken().getEmail();
    this.profile = securityContext.getIdToken().getProfile();
    this.picture = securityContext.getIdToken().getPicture();
    this.phoneNumber = securityContext.getIdToken().getPhoneNumber();
    this.scope = securityContext.getToken().getScope();
    securityContext.getIdToken().getOtherClaims()
        .forEach((key, value) -> System.out.println("@@@ key : " + key + " -> " + value));

    KeycloakPrincipal principal = (KeycloakPrincipal) httpRequest.getUserPrincipal();
    this.id = principal.getName();
    Set<String> roles =
        principal.getKeycloakSecurityContext().getToken().getRealmAccess().getRoles();
    this.roles.clear();
    this.roles.addAll(roles);
    System.out.println("@@@ Roles " + roles);

  }

  public String getTokenId() {
    return this.tokenId;
  }

  public String getId() {
    return this.id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getToken() {
    return token;
  }

  public String getProfile() {
    return profile;
  }

  public String getPicture() {
    return picture;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getRefreshToken() {
    return refreshToken;
  }

  public String logout() {
    try {
      this.httpRequest.logout();
    } catch (Exception ex) {
    }
    return "/index.xhtml";
  }

  public String getScope() {
    return this.scope;
  }

  public Set<String> getRoles() {
    return this.roles;
  }

  public boolean isUserInRole(final String role) {
    return this.roles.contains(role);
  }

  // checks whether the user in any of the given roles
  public boolean isUserInRole(final String... requiredRoles) {
    boolean isAuthorized = false;
    for (String requiredRole : requiredRoles) {
      isAuthorized |= this.roles.contains(requiredRole);
      if (isAuthorized) {
        break;
      }
    }
    return isAuthorized;
  }

}
