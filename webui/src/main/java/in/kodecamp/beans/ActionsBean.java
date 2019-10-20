package in.kodecamp.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ActionsBean {
  private String someValue;

  public ActionsBean() {
    System.out.println("Hello World");
    System.out.println("Hello World");
  }

  private String value;

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getSomeValue() {
    return someValue;
  }

  public void setSomeValue(String someValue) {
    this.someValue = someValue;
  }

  public String action1() {
    final String msg = "Hello " + this.value;
    return "actionresult?faces-redirect=true&amp;msg=" + msg;
  }

  public String action2() {
    final String msg = "Hello " + this.value;

    return "actionresult?faces-redirect=true&amp;msg=" + msg;
  }
}
