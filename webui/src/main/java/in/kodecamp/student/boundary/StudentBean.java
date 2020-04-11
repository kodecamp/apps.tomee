package in.kodecamp.student.boundary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import in.kodecamp.models.StudentEntity;
import in.kodecamp.security.LoggedInUser;
import in.kodecamp.student.control.StudentService;
import in.kodecamp.student.entity.Student;

@Named("studentBean")
@ViewScoped
public class StudentBean implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private String name = "Student Bean";
  private Collection<Student> students = new LinkedHashSet<>();
  private List<LinkedHashMap<String, Object>> studentList = new ArrayList<>();

  @Inject
  private StudentService studentService;

  @Inject
  private LoggedInUser user;

  public StudentBean() {
    System.out.println("@@@@@@@@@@@@@@ StudentBean : Constructor");
  }

  @PostConstruct
  public void init() {
    /* final JsonWebToken token = authService.authenticate(); */
    this.students.clear();
    /* this.students.addAll(studentService.listAll()); */
    try {
      System.out.println("Token : " + user.getToken());
      this.students.addAll(studentService.listAll(user.getToken()));
    } catch (Throwable ex) {
      System.err.println("error : " + ex.getMessage());
    }
  }

  // -------------- fields ------------------
  private StudentEntity se;
  private StudentEntity newStudent;

  // -------------private methods ----------

  // -------------- public methods ----------
  public String addNewStudent() {
    return null;
  }

  public String updateStudent() {
    return null;
  }

  public String deleteStudent() {
    return null;
  }

  public String fetchAllStudents() {
    return null;
  }

  public String getStudentDetails() {
    return null;
  }

  public String getName() {
    return this.name;
  }

  public String edit(final String rollNo) {
    System.out.println(" Edit Action : " + rollNo);
    return null;
  }

  public String delete(final String rollNo) {
    System.out.println(" Delete Action : " + rollNo);
    return null;
  }

  public String view(final String rollNo) {
    System.out.println(" ShowDetails Action : " + rollNo);
    return null;
  }

  public Collection<Student> getStudents() {
    return students;
  }

  /*
   * public LoggedInUser getUser() { return this.user; }
   */

  // getter ans setters

}
