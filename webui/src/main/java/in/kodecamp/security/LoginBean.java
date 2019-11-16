package in.kodecamp.security;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginBean {

  private String username;
  private String password;

  public LoginBean() {
    System.out.println("### LoginBean : constructor");
  }

  public void submit() {
    System.out.println("### LoginBean : submit");
    System.out.println("Username : " + username + " Password : " + password);
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  // getters and setters

}
