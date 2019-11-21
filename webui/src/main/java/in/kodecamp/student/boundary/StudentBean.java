package in.kodecamp.student.boundary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import in.kodecamp.models.StudentEntity;

@Named
@ViewScoped
public class StudentBean implements Serializable {

  // -------------- fields ------------------
  private StudentEntity se;
  private StudentEntity newStudent;
  private List<StudentEntity> students = new ArrayList<>();

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

  // getter ans setters

}
