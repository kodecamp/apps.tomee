package in.kodecamp.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class SampleBean {
  private String name = "Sunil Kumar";
  private String address;

  public SampleBean() {
    System.out.println("# Constructor: SampleBean");
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void doSomething() {
    System.out.println("Method called.");
    System.out.println("Name : " + this.name);
    System.out.println("Address : " + this.address);
    System.out.println("Address : " + this.address);
    System.out.println("Hello World");
  }

  public void doSomething(final String value) {
    System.out.println("Name : " + this.name);
    System.out.println("Address : " + this.address);
    System.out.println("Address : " + this.address);
  }

}
